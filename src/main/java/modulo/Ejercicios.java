/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public abstract class Ejercicios extends Elemento
{
    //Definir variables
    private String enunciado,explicación;
    
    //Constructor con parametros
    public Ejercicios(String enunciado, String puntos, int id, String titulo) {
        super(id, titulo);
        this.enunciado = enunciado;
        this.explicación = puntos;
    }
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getExplicación() {
        return explicación;
    }

    //SETS Y GETS
    public void setExplicación(String explicación) {
        this.explicación = explicación;
    }

    //Metodos abstractos
    public abstract String tipo();
    
    public abstract String[] opciones();
    
    public abstract String opcionCorrecta();
    
    //Metodos
    @Override
    public String información() {
        return super.información()+"\nTipo: "+tipo();
    }

    
    
}//fin clase Ejercicios
