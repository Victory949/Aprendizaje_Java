/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class Leccion 
{
    //Definir variables
    private String [] texto;
    private String ejemplos;
    private String titulo;
    private ArrayList <Ejercicios> ejercicio = new ArrayList<>();
    
    //CCONSTRUCTORES
    public Leccion() {
    }

    public Leccion(String[] texto, String ejemplos, String titulo) {
        this.texto = texto;
        this.ejemplos = ejemplos;
        this.titulo = titulo;
    }
    
    //GETS
    public String[] getTexto() {
        return texto;
    }

    public String getEjemplos() {
        return ejemplos;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void agregarEjercicio()
    {
        
    }
    
    public void totalEjercicios()
    {
        ejercicio.size();
    }
    
}//fin clase Leccion
