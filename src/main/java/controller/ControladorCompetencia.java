/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import javax.swing.Timer;
import model.*;
import view.*;

/**
 *
 * @author aaron
 */
public class ControladorCompetencia implements ActionListener{
    private static int puerto = 5000;
    
    private GUI_VistaModo vModo = new GUI_VistaModo();
    private GUI_VistaCompetencia vCompetencia= new GUI_VistaCompetencia();
    private GUI_VistaResultadosCompetencia vResultado= new GUI_VistaResultadosCompetencia();
    
    private Servidor server;
    private Cliente client;
    private Timer reloj = new Timer(100,this);
    
    private String nombre;
    private boolean jugando;
    private long inicio;

    public ControladorCompetencia()
    {
        
        reloj.setActionCommand("TICK");
        vModo.addModoListener(this);
        vCompetencia.addTerminarListener(this);
        vResultado.addResultadosListener(this);
    }
      
    public void iniciar()
    {
        vModo.setLocationRelativeTo(null);
        vModo.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opc = e.getActionCommand();
        
        switch(opc)
        {
            case "CREAR":
                crearPartida();
                break;
            case "UNIRSE":
                conectar(vModo.getIp());
                break;
            case "TERMINAR":
                if(jugando)
                {
                    client.enviarCodigo(vCompetencia.getCodigo());
                }
                break;
            case "VOLVER":
                volverAlMenu();
                break;
            case "TICK":
                revisarMensajes();
                
                if(jugando){
                    vCompetencia.actTiempo((int)((System.currentTimeMillis()-inicio)/1000));
                }
                break;
        }
    }
    
    private void crearPartida()
    {
        if(client!=null)
        {
            return;
        }
        
        try{
            server = new Servidor(puerto, vModo.getModoElegido());
            server.start();
        }
        catch(IOException e)
        {
            vModo.mostrarMensaje("No se pudo crear la partida, el puerto que digito está ocupado.");
            return;
        }
        
        conectar("localhost");
        
        if(client!=null)
        {
            vModo.mostrarMensaje("Esperando al rival...\nTu IP es: "+miIp());
        }
    }
    
    public void conectar(String ip)
    {
        if(client!=null)
        {
            return;
        }
        
        client = new Cliente(ip, puerto);
        if(client.conectar())
        {
            vModo.mostrarMensaje("Conectado, esperando al rival...");
            reloj.start();
        }
        else
        {
            client=null;
            vModo.mostrarMensaje("No se pudo conectar a"+ip);
            
            if(server!=null)
            {
                server.cerrar();
                server=null;
            }
        }
    }
    
    private String miIp()
    {
        try{
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch(IOException e)
        {
            return "desconocida.";
        }
    }
    
    public void revisarMensajes()
    {
        if(client==null)
        {
            return;
        }
        
        String mensaje = client.sigMensaje();
        
        while(mensaje!=null)
        {
            procesar(mensaje);
            if(client==null)
            {
                return;
            }
            mensaje = client.sigMensaje();
        }
    }
    
    public void procesar(String mensaje)
    {
        String[] partes = mensaje.split(":",3);
        
        switch(partes[0])
        {
            case "NOMBRE":
                nombre=partes[1];
                break;
            case "RETO":
                iniciarReto(Bloque.valueOf(partes[1]),partes[2]);
                break;
            case "INCORRECTO":
                vCompetencia.mostrarMensaje("Código incorrecto, revísalo e intenta de nuevo");
                break;
            case "GANADOR":
                terminar(partes[1],Integer.parseInt(partes[2]));
                break;
            case "DESCONECTADO":
                if(jugando)
                {
                    jugando=false;
                    vCompetencia.bloqueo();
                    vCompetencia.mostrarMensaje("Se perdió la conexión con el servidor");
                }
                break;
        }
    }
    
    public void iniciarReto(Bloque modo, String objetivo)
    {
        vModo.setVisible(false);
        
        vCompetencia.mostrarReto(modo, objetivo, nombre);
        vCompetencia.setLocationRelativeTo(null);
        vCompetencia.setVisible(true);
        
        inicio = System.currentTimeMillis();
        jugando=true;
    }
    
    public void terminar(String ganador, int segundos)
    {
        jugando=false;
        vCompetencia.bloqueo();
        vCompetencia.setVisible(false);
        
        vResultado.mostrarResultado(ganador.equals(nombre), ganador, segundos);
        vResultado.setLocationRelativeTo(null);
        vResultado.setVisible(true);
    }
    
    public void volverAlMenu()
    {
        reloj.stop();
        jugando=false;
        
        if(client!=null)
        {
            client.cerrar();
            client=null;
        }
        if(server!=null)
        {
            server.cerrar();
            server=null;
        }
        
        vResultado.setVisible(false);
        vCompetencia.setVisible(false);
        
        vModo.mostrarMensaje("");
        vModo.setLocationRelativeTo(null);
        vModo.setVisible(true);
    }
}
