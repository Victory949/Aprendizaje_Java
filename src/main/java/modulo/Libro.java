/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class Libro extends Elemento
{
    //Definir variables
    private String titulo;
    //creación ArrayList
   

    //CONSTRUCTORES
    public Libro(String titulo, int id) {
        super(id, titulo);
        this.titulo = titulo;
    }
    
    
    //GETS Y SETS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}//fin clase Libro
