/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author aaron
 */
public enum Bloque {
    bloqueIf("if","ejecuta código solo si la condición es verdadera"),
    bloqueIfElse("if else","elige entre dos caminos según la condición"),
    bloqueSwitch("switch","compara una variable y determina el camino dependiendo del caso");
    
    //VARIABLES
    private String txt,definicion;

    private Bloque(String txt, String definicion) {
        this.txt = txt;
        this.definicion = definicion;
    }

    public String getTxt() {
        return txt;
    }

    public String getDefinicion() {
        return definicion;
    }

    
    
}
