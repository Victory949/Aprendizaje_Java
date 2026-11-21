/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aaron
 */
public class ResultadosSimulador {
    //VARIABLES
    private int[] cantLineas;
    private String salida,explicacion;

    public ResultadosSimulador(int[] cantLineas, String salida, String explicacion) {
        this.cantLineas = cantLineas;
        this.salida = salida;
        this.explicacion = explicacion;
    }

    public int[] getCantLineas() {
        return cantLineas;
    }

    public String getSalida() {
        return salida;
    }

    public String getExplicacion() {
        return explicacion;
    }
    
    
}

