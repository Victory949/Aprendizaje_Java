/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aaron
 */
public class Competicion {
    //variable
    private ArrayList<Reto> r = new ArrayList<>();
    private Reto retoActual;
    private String ganador;
    private boolean terminada;
    private long inicio,tiempoGanador; 

    public Competicion() {
        cargarRetos();
    }
    
    //Gets

    public Reto getRetoActual() {
        return retoActual;
    }

    public String getGanador() {
        return ganador;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public int getTiempoGanador() {
        return (int)(tiempoGanador/1000);
    }
    
    
    public void cargarRetos()
    {
        //IF
        r.add(new Reto(Bloque.bloqueIf,"","",new String[]{}));
        
        r.add(new Reto(Bloque.bloqueIf,"","",new String[]{}));
        
        //IF-ELSE
        r.add(new Reto(Bloque.bloqueIfElse,"","",new String[]{}));
        r.add(new Reto(Bloque.bloqueIfElse,"","",new String[]{}));
        
        //SWITCH
        r.add(new Reto(Bloque.bloqueSwitch,"","",new String[]{}));
        r.add(new Reto(Bloque.bloqueSwitch,"","",new String[]{}));
    }
    
    public void iniciarReto(Bloque modo)
    {
        ArrayList<Reto> retoModo = new ArrayList<>();
        
        for(int i=0; i<retoModo.size();i++)
        {
            if(r.get(i).getModo()==modo)
            {
                retoModo.add(r.get(i));
            }
        }
        
        Random azar = new Random();
        retoActual= retoModo.get(azar.nextInt(retoModo.size()));
        
        ganador=null;
        terminada=false;
        inicio=System.currentTimeMillis();
    }
    
    public synchronized boolean entradaSimultanea(String jugador, String codigo)
    {
        if(terminada)
        {
            return false;
        }
        
        if(retoActual.evaluar(codigo))
        {
            ganador=jugador;
            terminada=true;
            tiempoGanador=System.currentTimeMillis()-inicio;
            return true;
        }
        return false;
    }
}
