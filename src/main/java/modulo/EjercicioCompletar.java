/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class EjercicioCompletar extends Ejercicios{
    
    //definir variables
    private String[] respuestaAceptada;

    public EjercicioCompletar(int id, String titulo, String enunciado, String[] respuestaAceptada, String explicacion) {
        super(enunciado, explicacion, id, titulo);
        this.respuestaAceptada = respuestaAceptada;
    }


    @Override
    public String tipo() {
        return "Completar código";
    }

    @Override
    public String[] opciones() {
        return new String[0];
    }

    @Override
    public String opcionCorrecta() {
        return respuestaAceptada[0];
    }

    @Override
    public boolean evaluar(String respuesta) {
        
        if(respuesta==null)
        {
            return false;
        }
        
        for(int i=0; i<respuestaAceptada.length;i++)
        {
            if(respuesta.trim().equals(respuestaAceptada[i]))
            {
                return true;
            }
        }
        //
        return false;
    }
    
    
    
}
