/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aaron
 */
public abstract class Ejercicios extends Elemento implements Evaluable
{
    //Definir variables
    private String enunciado,explicacion;
    
    //Constructor con parametros
    public Ejercicios(String enunciado, String explicacion, int id, String titulo) {
        super(id, titulo);
        this.enunciado = enunciado;
        this.explicacion = explicacion;
    }
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getExplicacion() {
        return explicacion;
    }

    //SETS Y GETS
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    //Metodos abstractos
    public abstract String tipo();
    
    public abstract String[] opciones();
    
    public abstract String opcionCorrecta();
    
    //Metodos    
    @Override
    public String correccion(String respuesta)
    {
        if(evaluar(respuesta))
        {
            return "¡Respuesta correcta!\n"+explicacion;
        }
        return "¡Respuesta incorrecta!\nLa respuesta correcta era: "+opcionCorrecta()+"\n"+explicacion;
    }
    
    @Override
    public String informacion() {
        return super.informacion()+"\nTipo: "+tipo();
    }

    
    
}//fin clase Ejercicios
