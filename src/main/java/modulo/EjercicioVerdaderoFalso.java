/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class EjercicioVerdaderoFalso extends Ejercicios{
    
    //definir variables
    private String verdadero,falso;
    private boolean rCorrecta;

    public EjercicioVerdaderoFalso(String verdadero, String falso, boolean rCorrecta, String enunciado, String explicacion, int id, String titulo) {
        super(enunciado, explicacion, id, titulo);
        this.verdadero = verdadero;
        this.falso = falso;
        this.rCorrecta = rCorrecta;
    }

    @Override
    public String tipo() {
        return "Verdadero o Falso";
    }

    @Override
    public String[] opciones() {
        return new String[]{verdadero,falso};
    }

    @Override
    public String opcionCorrecta() {
        return "¡La respuesta es "+(rCorrecta ? "verdadera!" : "falsa, te equivocaste!");
    }

    @Override
    public boolean evaluar(String respuesta) {
        if(respuesta==null)
        {
            return false;
        }
        return respuesta.equalsIgnoreCase(rCorrecta ? verdadero : falso);
    }

}
