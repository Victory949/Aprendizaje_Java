/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author aaron
 */
public class Simulador {
    //VARIABLES
    private final int simIf = 0;
    private final int simIfElse = 1;
    private final int simSwitch = 2;
    //final evita que se cambie el valor de la variable
    
    private String[] simuladores = {"if","if-else","switch"};

    public String[] getSimuladores() {
        return simuladores.clone();
        //copia superficial del arreglo
    }
    
    public String[] getCodigo(int tipo, String valor)
    {
        switch (tipo)
        {
            case simIf:
                return new String[]{
                    "int edad = "+valor+";",
                    "if(edad >= 18)",
                    "{",
                    "   System.out.println(\"¡Eres mayor de edad!\");",
                    "}",
                    "System.out.println(\"¡Fin del programa!\");",
                };
                
            case simIfElse:
                return new String[]{
                    "int nota = "+valor+";",
                    "if(nota >= 70)",
                    "{",
                    "   System.out.println(\"APROBADO\");",
                    "}",
                    "else",
                    "{",
                    "   System.out.println(\"REPROBADO\");",
                    "}",
                };
                
            case simSwitch:
                return new String[]{
                    "int dia = "+valor+";",
                    "switch(dia)",
                    "{",
                    "   case 1:",
                    "       System.out.println(\"Lunes\");",
                    "       break;",
                    "   case 2:",
                    "       System.out.println(\"Martes\");",
                    "       break;",
                    "   case 3:",
                    "       System.out.println(\"Miercoles\");",
                    "       break;",
                    "   case 4:",
                    "       System.out.println(\"Jueves\");",
                    "       break;",
                    "   default:",
                    "       System.out.println(\"Otro día\");",
                    "}",
                };
                
            default:
                return new String[0];
                
        }//fin switch
    }

    
    public ResultadosSimulador simular(int tipo, int valor)
    {
        switch (tipo)
        {
            case simIf:
                return simularIf(valor);
                
            case simIfElse:
                return simularIfElse(valor);
                
            case simSwitch:
                return simularSwitch(valor);
                
            default:
                return new ResultadosSimulador(new int[0],"","Simulación no detectada: "+tipo);

        }//fin switch
    }

    
    //SIMULADOR POR TIPO
    public ResultadosSimulador simularIf(int edad)
    {
        if(edad>=18)
        {
            return new ResultadosSimulador(new int[]{0,1,2,3,4,5},
                        "¡Eres mayor de edad!\n¡Fin del programa!",
                        edad+ ">=18 es VERDADERO, así que Java imprime el bloque de la estructura if");
        }
        return new ResultadosSimulador(new int[]{0,1,5},
                        "¡Fin del programa!",
                        edad+ ">=18 es FALSO, así que Java no imprime nada, saltando la estructura if");
    }
    
    public ResultadosSimulador simularIfElse(int nota)
    {
        if(nota>=70)
        {
            return new ResultadosSimulador(new int[]{0,1,2,3,4},
                        "APROBADO",
                        nota+ ">=70 es VERDADERO, se ejecuta el bloque if y el else se ignora.");
        }
        return new ResultadosSimulador(new int[]{0,1,5,6,7,8},
                        "REPROBADO",
                        nota+ ">=70 es FALSO, así que Java salta directo al else y ejecuta ese bloque.");
    }
    
    public ResultadosSimulador simularSwitch(int dia)
    {
        switch (dia)
        {
            case 1:
                return new ResultadosSimulador(new int[]{0,1,3,4,5},"Lunes",
                            "día vale 1: coincide con case 1, imprime y break sale del switch");
            case 2:
                return new ResultadosSimulador(new int[]{0,1,6,7,8},"Martes",
                            "día vale 2: coincide con case 2, imprime y break sale del switch.");
            case 3:
                return new ResultadosSimulador(new int[]{0,1,9,10,11},"Miercoles",
                            "día vale 3: coincide con case 3, imprime y break sale del switch.");
            case 4:
                return new ResultadosSimulador(new int[]{0,1,12,13,14},"Jueves",
                            "día vale 4: coincide con case 4, imprime y break sale del switch.");
            default:
                return new ResultadosSimulador(new int[]{0,1,15,16},"Otro día",
                            dia+ " no coincide con ningún case, así que se ejecuta default.");
        }
    }
    
}