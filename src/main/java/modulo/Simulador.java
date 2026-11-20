/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class Simulador {
    //VARIABLES
    private int simIf = 0;
    private int simIfElse = 1;
    private int simSwitch = 2;
    
    private String[] simuladores = {"if","if-else","switch"};

    public String[] getSimuladores() {
        return simuladores.clone();
        //copia superficial del arreglo
    }
    
    public String[] getCodigo()
    {
        return null;
    }
    
    public ResultadosSimulador simular(int tipo, int valor)
    {
        return null;
    }
    
    //SIMULADOR POR TIPO
    public ResultadosSimulador simularIf(int edad)
    {
        return null;
    }
    
    public ResultadosSimulador simularIfElse(int nota)
    {
        return null;
    }
    
    public ResultadosSimulador simularSwitch(int dia)
    {
        return null;
    }
    
}
/*

*/