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
public class Libro extends Elemento
{
    //creación ArrayList
    private String explicacion;
    private ArrayList<Leccion> lecciones = new ArrayList<>();
   

    //CONSTRUCTORES
    public Libro(int id, String titulo, String explicacion) {
        super(id, titulo);
        this.explicacion = explicacion;
    }
    
    //GET
    public String getExplicacion() {
        return explicacion;
    }
    
    
    //METODOS
    public void agregarLeccion(Leccion lec)
    {
        if(lec!=null)
        {
            lecciones.add(lec);
        }
    }
    
    public int totalLecciones()
    {
        return lecciones.size();
    }
    
    public Leccion getLeccion(int posicion)
    {
        return lecciones.get(posicion);
    }
    
    public int totalEjerciciosLibro()
    {
        int total=0;
        for(int i=0; i<lecciones.size();i++)
        {
            total+= lecciones.get(i).totalEjercicios();
        }
        
        return total;
    }
    
    
}//fin clase Libro
