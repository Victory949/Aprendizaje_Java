/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aaron
 */
public class Reto implements Evaluable{
    //variables
    private Bloque modo;
    private String objetivo,solucion;
    private String[] requeridos;

    public Reto(Bloque modo, String objetivo, String solucion, String[] requeridos) {
        this.modo = modo;
        this.objetivo = objetivo;
        this.solucion = solucion;
        this.requeridos = requeridos;
    }

    public Bloque getModo() {
        return modo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getSolucion() {
        return solucion;
    }

    public String limpiar(String txt)
    {
        return txt.replace(" ", "").replace("\n", "");
    }
    
    @Override
    public boolean evaluar(String respuesta) {
        if(respuesta==null)
        {
            return false;
        }
        String codigo = limpiar(respuesta);
        
        if(codigo.equals(""))
        {
            return false;
        }
        
        //cumplimiento de requerimientos
        for(int i=0; i<requeridos.length;i++)
        {
            if(!codigo.contains(limpiar(requeridos[i])))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public String correccion(String respuesta) {
        if(evaluar(respuesta))
        {
            return "¡Código correcto!";
        }
        
        return "¡Código erroneo!\nUna solución era:\n"+solucion;
    }
    
    
}
