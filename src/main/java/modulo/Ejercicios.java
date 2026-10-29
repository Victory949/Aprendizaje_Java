/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public abstract class Ejercicios 
{
    //Definir variables
    private String enunciado;
    private int puntos;
    
    //Constructor con parametros
    public Ejercicios(String enunciado, int puntos) {
        this.enunciado = enunciado;
        this.puntos = puntos;
    }
    
    //SETS Y GETS
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}//fin clase Ejercicios
