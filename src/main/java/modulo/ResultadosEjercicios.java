/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class ResultadosEjercicios {
    
    //VARIABLES PARA LLEVAR EL REGISTRO DEL USUARIO EN LAS PREGUNTAS
    private int[][] estados;
    private String[][] respuestas;
    private int intento = 1;
    //variables para estado
    private int acierto,fallo,nulo;

    public ResultadosEjercicios(int capitulos, int ejerciciosCapitulo) {
        estados =  new int[capitulos][ejerciciosCapitulo];
        respuestas = new String[capitulos][ejerciciosCapitulo];
    }
    
    public boolean registroEstado(int capitulo, int ejercicio, boolean correcta, String respuesta)
    {
        if(estados[capitulo][ejercicio] != nulo)
        {
            return false;
        }
        
        respuestas[capitulo][ejercicio] = respuesta;
        
        if(correcta)
        {
            estados[capitulo][ejercicio] = acierto;
        }
        else
        {
            estados[capitulo][ejercicio] = fallo;
        }
        return true;
    }
    
    public int contarEstado(int capitulo, int estado)
    {
        int total = 0;
        for(int i=0; i<estados[capitulo].length;i++)
        {
            if (estados[capitulo][i] == estado)
            {
                total++;
            }
        }
        return total;
    }
    
    //RETORNOS
    public int getAciertos(int capitulo)
    {
        return contarEstado(capitulo,acierto);
    }
    
    public int getFallos(int capitulo)
    {
        return contarEstado(capitulo,fallo);
    }
    
    public int cantRespuestas(int capitulo)
    {
        return getAciertos(capitulo)+getFallos(capitulo);
    }
}