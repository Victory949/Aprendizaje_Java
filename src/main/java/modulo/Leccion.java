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
public class Leccion extends Elemento
{
    //Definir variables
    private String [] texto;
    private String ejemplos;
    private ArrayList <Ejercicios> ejercicio = new ArrayList<>();
    
    //CONSTRUCTORES
    public Leccion(String[] texto, String ejemplos, int id, String titulo) {
        super(id, titulo);
        this.texto = texto;
        this.ejemplos = ejemplos;
    }
    
    //GETS
    public String[] getTexto()
    {
        return texto;
    }

    public String getEjemplos()
    {
        return ejemplos;
    }

    //METODOS
    public void agregarEjercicio(Ejercicios e)
    {
        if(e!=null)
        {
            ejercicio.add(e);
        }
        
    }
    
    public int totalEjercicios()
    {
        return ejercicio.size();
    }
    
    public Ejercicios getEjercicios(int posicion)
    {
        return ejercicio.get(posicion);
    }
    
}//fin clase Leccion
