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
public class Jugador {
    //variables
    public static int ancho=30;
    public static int alto=48;
   
    private int x,y;
    private int velocidadX;
    private double velocidadY;
    private boolean enSuelo;
    private ContenidoBloque bloqueCargado;
    
    //ANIMACIONES
    //cuando este en 1 es derecha, cuando este en -1 es izquierda
    private int direccion =1; 
    private boolean agachado;
    private boolean acrobatico; //true durante segundo salto
    private int saltosUsados;
    private int ticksEnAire;
    private int ticksAnimacion;

    public Jugador(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    public double getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(double velocidadY) {
        this.velocidadY = velocidadY;
    }

    public boolean isEnSuelo() {
        return enSuelo;
    }

    public void setEnSuelo(boolean enSuelo) {
        this.enSuelo = enSuelo;
    }

    public ContenidoBloque getBloqueCargado() {
        return bloqueCargado;
    }

    public void setBloqueCargado(ContenidoBloque bloqueCargado) {
        this.bloqueCargado = bloqueCargado;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public boolean isAgachado() {
        return agachado;
    }

    public void setAgachado(boolean agachado) {
        this.agachado = agachado;
    }

    public boolean isAcrobatico() {
        return acrobatico;
    }

    public void setAcrobatico(boolean acrobatico) {
        this.acrobatico = acrobatico;
    }

    public int getSaltosUsados() {
        return saltosUsados;
    }

    public void setSaltosUsados(int saltosUsados) {
        this.saltosUsados = saltosUsados;
    }

    public int getTicksEnAire() {
        return ticksEnAire;
    }

    public void setTicksEnAire(int ticksEnAire) {
        this.ticksEnAire = ticksEnAire;
    }

    public int getTicksAnimacion() {
        return ticksAnimacion;
    }

    public void setTicksAnimacion(int ticksAnimacion) {
        this.ticksAnimacion = ticksAnimacion;
    }
    
    public Rectangle getArea()
    {
        return new Rectangle (x,y,ancho,alto);
    }
}
/*

*/