/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aaron
 */
public class EjercicioEleccionMultiple extends Ejercicios{
    
    //def variables
    private String[] opciones;
    private int rCorrecta;

    public EjercicioEleccionMultiple(int id, String titulo,String enunciado,String[] opciones, int rCorrecta, String explicacion) {
        super(enunciado, explicacion, id, titulo);
        this.opciones = opciones;
        this.rCorrecta = rCorrecta;
    }
    
    @Override
    public String tipo() {
        return "Elección Multiple";
    }

    @Override
    public String[] opciones() {
        return opciones.clone();
        //clone() deja una copia del arreglo para así no afectar el original
    }

    @Override
    public String opcionCorrecta() {
        return opciones[rCorrecta];
    }

    @Override
    public boolean evaluar(String respuesta) {
        return respuesta!= null&& respuesta.equals(opciones[rCorrecta]);
    }

}
