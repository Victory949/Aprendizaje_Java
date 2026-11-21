/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author aaron
 */
public class Elemento {
    //definir variables
    private int id;
    private String titulo;
    
    //Constructor
    public Elemento(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    
    //GETS & SETS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    //Metodo informativo
    public String informacion()
    {
        return "Id: "+getId() + "\nTitulo: "+getTitulo();
    }
    
    
}