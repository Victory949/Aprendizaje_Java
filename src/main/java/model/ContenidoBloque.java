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
public class ContenidoBloque {
    //variables
    public static int ancho=90;
    public static int alto=30;
    
    private Bloque tipoBloque;
    private int xInicial,yInicial;
    private int x,y;
    private boolean bloqueCargado,bloqueColocado;

    public ContenidoBloque(Bloque tipoBloque, int x, int y) {
        this.tipoBloque = tipoBloque;
        this.xInicial = x;
        this.yInicial = y;
        this.x = x;
        this.y = y;
    }
    
    public Bloque getTipoBloque()
    {
        return tipoBloque;
    }
    
    //POSICIONES
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setPosicion(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    //METODOS RESPECTO AL BLOQUE
    public boolean isBloqueCargado()
    {
        return bloqueCargado;
    }

    public void setBloqueCargado(boolean bloqueCargado) {
        this.bloqueCargado = bloqueCargado;
    }

    public boolean isBloqueColocado()
    {
        return bloqueColocado;
    }
    
    public void setBloqueColocado(boolean bloqueColocado) {
        this.bloqueColocado = bloqueColocado;
    }
    
    public void reiniciar()
    {
        this.x=xInicial;
        this.y=yInicial;
        this.bloqueCargado=false;
        this.bloqueColocado=false;
    }
    
    public Rectangle getArea()
    {
        return new Rectangle (x,y,ancho,alto);
    }
}