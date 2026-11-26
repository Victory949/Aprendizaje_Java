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
        r.add(new Reto(Bloque.bloqueIf,"Digita un if que imprima \"Mayor de edad\" únicamente cuando la variable sea mayor o igual a 18.","if (edad>=){\n   System.out.println(\"Mayor de edad\");\n} ", new String[]{"if", "edad>=18","System.out.println","Mayor de edad"}));
        r.add(new Reto(Bloque.bloqueIf,"","",new String[]{}));
        
        //IF-ELSE
        r.add(new Reto(Bloque.bloqueIfElse,"Digite un if-else que imprima \"Aprobado\" si la nota es mayor o igual a 70, y \"Reprobado\" caso contrario.","if (nota>=70){\nSystem.out.println(\"Aprobado\");\n} else{\nSystem.out.println(\"Reprobado\");\n}", new String[]{"if", "nota>=70","Aprobado","else","Reprobado"}));
        r.add(new Reto(Bloque.bloqueIfElse,"","",new String[]{}));
        
        //SWITCH
        r.add(new Reto(Bloque.bloqueSwitch,"Digite un switch que tenga opciones para imprimir \"Iniciar\" si vale 1, \"Salir\" si vale 2, y \"No válido\" si no es ninguno de los dos. Use la variable int opcion.", "switch(opcion){\ncase 1:\nSystem.out.println(\"Iniciar\");\nbreak;\ncase 2:\nSystem.out.println(\"Salir\");\nbreak;\ndefault:\nSystem.out.println(\"No válido\");\n}", new String[]{"switch","opcion","break", "case 1","Iniciar", "case 2","Salir","default","No válido"}));
        r.add(new Reto(Bloque.bloqueSwitch,"","",new String[]{}));
    }
    
    public void iniciarReto(Bloque modo)
    {
        ArrayList<Reto> retoModo = new ArrayList<>();
        
        for(int i=0; i<r.size();i++)
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
