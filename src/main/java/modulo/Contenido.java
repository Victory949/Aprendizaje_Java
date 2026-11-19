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
                "Elección Multiple", //titulo
                "¿Cúal resultado imprime este código?" //enunciado
                +"int edad = 15;\nif (edad >=18){\n"
                        + "System.out.println(\"Mayor\");}\n",
                new String[]{"Nulo","Menor","No se obtuvo resultado"},2, //opciones & rCorrecta
                "15>=18 es falso, así que Java no imprime nada." //explicacion
                
        ));
                  
        l.agregarEjercicio(new EjercicioVerdaderoFalso(
                902, //id
                "Verdadero o Falso", //titulo
                "¿La estructura if solo posee un solo operador lógico?", //enunciado
                "Verdadero","Falso",
                false,
                "Es falso, Java posee 6 operadores lógicos\n"
                        + "&& = AND (Devuelve true solo si ambos operandos son true. Si el primero es false, no evalúa el segundo.)"
                        + "|| = OR (Devuelve true si al menos uno de los operandos es true. Si el primero es true, no evalúa el segundo.)"
                        + "! = NOT (Invierte el valor booleano (true pasa a false y false a true). Es un operador unario.)"
                        + "^ = XOR (Devuelve true solo cuando un operando es true y el otro es false (si ambos son iguales, devuelve false).)"
                        + "& = AND sin cortocircuito (Igual que &&, pero siempre evalúa ambos operandos.)"
                        + "| = OR sin cortocircuito (Igual que ||, pero siempre evalúa ambos operandos.)"
        ));
        
        l.agregarEjercicio(new EjercicioCompletar(
                903, //id
                "Complete el código", // titulo
                "Complete el espacio en blanco para que el programa muestre el mensaje solo cuando la temperatura sea mayor a 30"
                        + "\n\n"
                        + "int temperatura = 35;\n\n"
                        + "if (____________________){\n"
                        + " System.out.println(\"Hace calor\");\n"
                        + "\n}", //enunciado
                new String[]{"temperatura > 30","temperatura>30"}, //respuestaAceptada
                "La condición se cumplea cuando la temperatura es estrictamente mayor a 30, por eso se usa > y no >=" //explicacion
        ));
        
        l.agregarEjercicio(new EjercicioCompletar(
                904, //id
                "Complete el código", // titulo
                "Complete el espacio en blanco para que el programa determine si un estudiante tiene autorización para acceder a una plataforma académica"
                        + "\nINSTRUCCIONES"
                        + "\nEl estudiante debe tener una edad igual o superior a 18 años."
                        + "\nDebe de estar matriculado"
                        + "\nDebe de tener la cuenta activa"
                        + "\nSi cumple todas las condiciones, el programa debe mostrar el mensaje de acceso autorizado\n\n"
                            + "int edad = 20;\n" +
                            "boolean matriculado = true;\n" +
                            "boolean cuentaActiva = true;\n" +
                            "\n" +
                            "if (____________________________) {\n" +
                            "    System.out.println(\"Acceso autorizado\");\n" +
                            "}\n", //enunciado
                    new String[]{"edad >= 18 && matriculado && cuentaActiva","edad >= 18 && matriculado == true && cuentaActiva == true"}, //respuestaAceptada
                "Se utiliza && porque las tres condiciones deben cumplirse para autorizar el acceso." //explicacion
        ));

        l.agregarEjercicio(new EjercicioEleccionMultiple(
                905, //id
                "Elección Multiple", //titulo
                "¿Cuándo se ejecuta el bloque de un if?", //enunciado
                new String[]{"Siempre", "Cuando la condición es verdadera", "Cuando la condición es falsa"},1, //opciones & rCorrecta
                "Solo se ejecuta una estructura if cuando se cumple su condición" //explicacion
                
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
        +"   System.out.println(\"Es menor de edad\");\n"
        + "}\n",
        2,"Estructura if-else");
        
        //EJERCICIOS
        l.agregarEjercicio(new EjercicioEleccionMultiple(
                801, //id
                "Elección Multiple", //titulo
                "¿Qué estructura ofrece dos caminos según la condición?", //enunciado
                new String[]{"if", "if-else", "switch"},1, //opciones & rCorrecta
                "La estrucuctura if-else ofrece un camino si la condición se cumple o no." //explicacion
        ));
        
        1
        
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
           +"       System.out.println(\"Dia no valido\");\n"
           + "}\n",
           3,"Estructura switch");
        
        return l;
    }
    
}
