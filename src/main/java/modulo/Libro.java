/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class Libro 
{
    //Definir variables
    private String titulo;

    //CONSTRUCTORES
    public Libro() {
    }

    public Libro(String titulo) {
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
