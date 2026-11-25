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
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author aaron
 */
public class Cliente extends Thread{
    //variables
    private String ip;
    private int puerto;
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private ConcurrentLinkedQueue<String> mensajes = new ConcurrentLinkedQueue<>();

    public Cliente(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }
    
    public boolean conectar()
    {
        try{
            socket = new Socket(ip,puerto);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            salida= new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"),true);
            start();
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }
    
    public void enviarCodigo(String codigo)
    {
        salida.println("TERMINE:"+codigo.replace("\n", " "));
    }
    
    public String sigMensaje()
    {
        return mensajes.poll();
    }
    
    public void cerrar()
    {
        try
        {
            socket.close();
        }
        catch(IOException e)
        {
            System.out.println("Error al cerrar: "+e.getMessage());
        }
    }

    @Override
    public void run() {
        try
        {
            String txt;
            while((txt=entrada.readLine())!=null)
            {
                mensajes.add(txt);
            }
        }
        catch(IOException e)
        {
            mensajes.add("DESCONECTADO");
        }
    }
    
    
}
