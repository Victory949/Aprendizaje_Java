/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author aaron
 */
public class ManejadorCliente extends Thread{
    //variables
    private Servidor server;
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private String nombre;

    public ManejadorCliente(Servidor server, Socket socket, String nombre) throws IOException
    {
        this.server = server;
        this.socket = socket;
        this.nombre = nombre;
        this.entrada = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        this.salida = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
    }

    public String getNombre() {
        return nombre;
    }
    
    public void enviar (String mensaje)
    {
        salida.println(mensaje);
    }

    @Override
    public void run() {
        try
        {
            String txt;
            while((txt=entrada.readLine())!=null)
            {
                server.procesar(this,txt);
            }
        }
        catch(IOException e)
        {
            System.out.println(nombre+" se desconecto.");
        }
    }
    
    
}
