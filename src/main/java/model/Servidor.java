/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class Servidor extends Thread{
    //variables
    private int puerto;
    private Bloque modo;
    private ServerSocket server;
    private ArrayList<ManejadorCliente> clients = new ArrayList<>();
    private Competicion c = new Competicion();

    public Servidor(int puerto, Bloque modo) throws IOException
    {
        this.puerto = puerto;
        this.modo = modo;
        this.server = new ServerSocket(puerto);
    }

    @Override
    public void run() {
        try{
            while(clients.size()<2)
            {
                Socket socket = server.accept();
                ManejadorCliente cliente = new ManejadorCliente(this,socket,"Jugador "+(clients.size()+1));
                clients.add(cliente);
                cliente.start();
                cliente.enviar("NOMBRE:"+cliente.getNombre());
            }
            
            c.iniciarReto(modo);
            enviarATodos("RETO:"+modo.name()+":"+c.getRetoActual().getObjetivo());
        }
        catch(IOException e)
        {
            System.out.println("Error del servidor: "+e.getMessage());
        }
    }
    
    public void procesar(ManejadorCliente origen, String mensaje)
    {
        if(mensaje.startsWith("TERMINE:"))
        {
            String codigo = mensaje.substring(8);
            if(c.entradaSimultanea(origen.getNombre(),codigo))
            {
                enviarATodos("GANADOR:"+c.getGanador()+":"+c.getTiempoGanador());
            }
            else if(!c.isTerminada())
            {
                origen.enviar("INCORRECTO");
            }
        }
    }
    
    public void enviarATodos(String mensaje)
    {
        for(int i=0;i<clients.size();i++)
        {
            clients.get(i).enviar(mensaje);
        }
    }
    
}
