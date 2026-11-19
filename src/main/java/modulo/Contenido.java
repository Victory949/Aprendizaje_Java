/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

/**
 *
 * @author aaron
 */
public class Contenido {

    public Contenido() {
    }
    
    public Libro crearLibro()
    {
        Libro l = new Libro(0, "Aprendizaje Java",
                            "Libro interactivo para aprender sobre las estructuras condicionales de Java"
                            +"(if, if-else & switch) leyendo, analizando y practicando que camino seguir con cada código");
        l.agregarLeccion(crearCapitulo1());
        l.agregarLeccion(crearCapitulo2());
        l.agregarLeccion(crearCapitulo3());
        
        return l;
    }
    
    public Leccion crearCapitulo1()
    {
        Leccion l = new Leccion(new String[]{
                       "Objetivo: comprender él como un programa decide si ejecuta o no un bloque de código.",
                       "La estructura if ejecuta un bloque solo cuando una condicion es verdadera"
                       + "Java evalua la condicion entre parentesis y, si es true,\n ejecuta las instrucciones dentro de las llaves."},
                       "int edad = 20;\n"
                       +"if (edad >= 18)\n"
                       +"{\n"
                       +"   System.out.println(\"Es mayor de edad\");\n"
                       +"}",
                       1,"Estructura if");

        
        //AGREGAR EJERCICIOS
        l.agregarEjercicio(new EjercicioEleccionMultiple(
                901, //id
                "Elegir el camino", //titulo
                "¿Cúal resultado imprime este código?" //enunciado
                +"int edad = 15;\nif (edad >=18){\n"
                        + "System.out.println(\"Mayor\");\n}\nelse{\n"
                        + " System.out.println(\"Menor\");\n",
                new String[]{"Nulo","Menor","Ambos","Mayor"},1, //opciones & rCorrecta
                "15>=18 es falso, así que Java salta al else y se imprime \"Menor\"." //explicacion
                
        ));


        return l;
    }
    
    public Leccion crearCapitulo2()
    {
        Leccion l= new Leccion(new String[]{
        "Objetivo: comprender él como un programa decide ejecuta un comando dependiendo de si una condición es verdadera o falsa.",
        "La estructura if-else ofrece dos caminos: uno si la condicion es verdadera(if) y otro si es falsa(else)"},
        "int edad = 15;\n"
        +"if (edad >=18)\n"
        +"{\n"
        +"   System.out.println(\"Es mayor de edad\");\n"
        +"}\n"
        +"else\n"
        +"{\n"
        +"   System.out.println(\"Es menor de edad\");\n",
        2,"Estructura if-else");
        
        return l;
    }
    
    public Leccion crearCapitulo3()
    {
        Leccion l = new Leccion(new String[]{
            "Objetivo: comprender como se ejecuta un comando dependiendo de diferentes casos",
            "La estructura switch compara una variable contra varios casos y ejecuta el que coindice"
               + "\npara evitar respuestas que no aparecen, se usa el default"},
            "int dia = 3;\n"
           +"switch (dia)\n"
           +"{\n"
           +"   case 1:\n"
           +"       System.out.println(\"Lunes\");\n"
           +"       break;\n"
           +"   case 2:\n"
           +"       System.out.println(\"Martes\");\n"
           +"       break;\n"
           +"   case 3:\n"
           +"       System.out.println(\"Miercoles\");\n"
           +"       break;\n"
           +"   default:\n"
           +"       System.out.println(\"Dia no valido\");\n",
           3,"Estructura switch");
        
        return l;
    }
    
}
