/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Rectangle;

/**
 *
 * @author aaron
 */
public class CuadroDefinicion {
    //variables
    private int ancho=200;
    private int alto=70;
    
    private Bloque tipoBloque;
    private int x,y;
    private int colocado;

    public CuadroDefinicion(Bloque tipoBloque, int x, int y) {
        this.tipoBloque = tipoBloque;
        this.x = x;
        this.y = y;
    }

    public Bloque getTipoBloque() {
        return tipoBloque;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColocado() {
        return colocado;
    }

    public void agregarBloque()
    {
        colocado++;
    }
    
    public void reiniciar()
    {
        colocado=0;
    }
    
    public Rectangle getArea()
    {
        return new Rectangle (x,y,ancho,alto);
    }
}