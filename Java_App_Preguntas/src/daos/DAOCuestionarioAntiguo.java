/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import clases.Pregunta;
import enums.Dificultad;
import java.util.ArrayList;

/**
 *
 * @author beni-
 */
public class DAOCuestionarioAntiguo {
    
    ArrayList<Pregunta> preguntasFaciles;
    ArrayList<Pregunta> preguntasIntermedias;
    
    public DAOCuestionarioAntiguo(){
        preguntasFaciles = this.PreguntasFaciles();
        preguntasIntermedias = this.PreguntasIntermedias();
    }
   
    public ArrayList<Pregunta> getPreguntasFaciles(){
        return this.preguntasFaciles;
    }
    
    public ArrayList<Pregunta> getPreguntasIntermedias(){
        return this.preguntasIntermedias;
    }
   
    private ArrayList<Pregunta> PreguntasFaciles(){
        
        ArrayList<Pregunta> preguntas = new ArrayList();
        
        String[] respuestas1 = {
            "Es un concepto similar al de 'array'",
            "Es un tipo particular de variable",
            "Es un modelo o plantilla a partir de la cual creamos objetos",
            "Es una categoria de datos ordenada secuencialmente"
        };
        
        Pregunta p = new Pregunta("¿Cuál es la descripción que crees que define mejor el concepto 'clase' en la programación orientada a objetos?", respuestas1, 2);
        preguntas.add(p);
        
        
        
        String[] respuestas2 = {
            "Sus cardinalidad y su tipo",
            "Sus atributos y sus métodos",
            "La forma en que establece comunicación e intercambia mensajes",
            "Su interfaz y los eventos asociados"
        };
        
        p = new Pregunta("¿Qué elementos crees que definen a un objeto?", respuestas2, 1);
        preguntas.add(p);
        
        
        
        String[] respuestas3 = {
            "public class Componente extends Producto",
            "public class Componente inherit Producto",
            "public class Componente implements Producto",
            "public class Componente belong to Producto"
        };
        
        p = new Pregunta("¿Qué código de los siguientes tiene que ver con la herencia?", respuestas3, 0);
        preguntas.add(p);
        
        
        
        String[] respuestas4 = {
            "Duplicar una clase",
            "Eliminar una clase",
            "Crear un objeto a partir de la clase",
            "Conectar dos clases entre sí"
        };
        
        p = new Pregunta("¿Qué significa instanciar una clase?", respuestas4, 2);
        preguntas.add(p);
        
        
        
        String[] respuestas5 = {
            "Una función utilizada para intercambiar valores",
            "Es el sobrenombre de la versión 1.3 del JDK",
            "Un framework específico para Android",
            "Una librería para construir interfaces gráficas"
        };
        
        p = new Pregunta("En Java, ¿a qué nos estamos refiriendo si hablamos de 'Swing'?", respuestas5, 3);
        preguntas.add(p);
        
        
        
        String[] respuestas6 = {
            "Una libreria de Java",
            "Una versión de Java especial para servidores",
            "Un IDE para desarrollar aplicaciones",
            "Ninguna de las anteriores"
        };
        
        p = new Pregunta("¿Qué es Eclipse?", respuestas6, 2);
        preguntas.add(p);
        
        
        
        String[] respuestas7 = {
            "El formato de intercambio de datos",
            "El formato que obtenemos tras compilar un fuente .java",
            "Un tipo de variable",
            "Un depurador de código"
        };
        
        p = new Pregunta("¿Qué es el bytecode en Java?", respuestas7, 1);
        preguntas.add(p);
        
        
        
        String[] respuestas8 = {
            "public class Componente interface Product",
            "Componente cp = new Componente (interfaz)",
            "public class Componente implements Printable",
            "Componente cp = new Componente.interfaz"
        };
        
        p = new Pregunta("¿Qué código asociarías a una Interfaz en Java?", respuestas8, 2);
        preguntas.add(p);
        
        
                
        String[] respuestas9 = {
            "Editarlo para modificar su comportamiento",
            "Cambiarle el nombre dejándolo con la misma funcionalidad",
            "Crear un método con el mismo nombre pero diferentes argumentos",
            "Añadirle funcionalidades a un método"
        };
        
        p = new Pregunta("¿Qué significa sobrecargar (overload) un método?", respuestas9, 2);
        preguntas.add(p);
        
        
                        
        String[] respuestas10 = {
            "Un error que lanza un método cuando algo va mal",
            "Un objeto que no puede ser instanciado",
            "Un bucle que no finaliza",
            "Un tipo de evento muy utilizado al crear interfaces"
        };
        
        p = new Pregunta("¿Qué es una excepción?", respuestas10, 0);
        preguntas.add(p);
        
        
        
        String[] respuestas11 = {
            "Extends",
            "Public",
            "Implements",
            "Interface"
        };
        
        p = new Pregunta("¿Qué se debe utilizar para simular la herencia múltiple de una clase?", respuestas11, 3);
        preguntas.add(p);
        
        return preguntas;
    }
    
    private ArrayList<Pregunta> PreguntasIntermedias(){
        
        ArrayList<Pregunta> preguntas = new ArrayList();
        
        String[] respuestas1 = {
            "Inicializar una funcion",
            "Inicializar un vector o arreglo",
            "Inicializar el metodo",
            "Ninguna de las anteriores"
        };
        
        Pregunta p = new Pregunta("Qué hace: boton = new JButton[20]", respuestas1, 1);
        preguntas.add(p);
        
        
        
        String[] respuestas2 = {
            "Entero",
            "Double",
            "String",
            "Todas son correctas"
        };
        
        p = new Pregunta("Tipo de dato para un 5,6 es:", respuestas2, 1);
        preguntas.add(p);
        
        
        
        String[] respuestas3 = {
            "if (condición) { instrucción 1, instrucción 2 }",
            "if (condición) { instrucción 1; instrucción 2; }",
            "if condición { instrucción 1, instrucción 2 }",
            "if (condición) { instrucción 1, instrucción 2"
        };
        
        p = new Pregunta("La funcion if se escribe:", respuestas3, 1);
        preguntas.add(p);
        
        
        
        String[] respuestas4 = {
            "for (int i=1;i<8;i++){}",
            "for (int i=1;i<8;i++)",
            "for ( i=1;i<8;i++)",
            "for (i=1;i<8;i++){}"
        };
        
        p = new Pregunta("La estructura correcta del for es:", respuestas4, 0);
        preguntas.add(p);
        
        
        
        String[] respuestas5 = {
            "Capturar datos del mouse",
            "Capturar fotos",
            "Capturar pantallazos",
            "Capturar datos por teclado"
        };
        
        p = new Pregunta("Scanner teclado=new Scanner(System.in); permite:", respuestas5, 3);
        preguntas.add(p);
        
        
        
        String[] respuestas6 = {
            "public Class",
            "package",
            "void main",
            "metodo"
        };
        
        p = new Pregunta("Las librerias se llaman dentro de: ", respuestas6, 1);
        preguntas.add(p);
        
        
        
        String[] respuestas7 = {
            "Asignar a la variable caja un cuadro de texto",
            "Asignar a la variable caja un circulo",
            "Asignar a la variable caja datos numericos",
            "Todas son correctas"
        };
        
        p = new Pregunta("La linea, caja = new JTextField(); permite", respuestas7, 0);
        preguntas.add(p);
        
        
        
        String[] respuestas8 = {
            "Crear marcos o ventanas",
            "Crear elipses",
            "Crear grillas",
            "Ninguna de las anteriores"
        };
        
        p = new Pregunta("JFrame permite: ", respuestas8, 0);
        preguntas.add(p);
        
        
                
        String[] respuestas9 = {
            "Si",
            "No",
            "Las dos anteriores",
            "Ninguna de las anteriores"
        };
        
        p = new Pregunta("¿ Es correcto escribir: int a,b; String Suma, ?", respuestas9, 1);
        preguntas.add(p);
        
        
                        
        String[] respuestas10 = {
            "Agregar el nombre del programa en la barra de titulo",
            "Agregar el nombre en la barra de estado",
            "Agregar el nombre del programa en la ventana de comandos",
            "Cerrar el programa"
        };
        
        p = new Pregunta("la linea, super (\"Crepusculo\"); permite:", respuestas10, 0);
        preguntas.add(p);
        
        
        
        String[] respuestas11 = {
            "Mostrar una ventana que permite capturar datos ingresados por teclado",
            "Mostrar una ventana que permite desplegar datos",
            "mostrar datos desde consola",
            "Todas las anteriores"
        };
        
        p = new Pregunta("JOptionPane.showInputDialoge permite", respuestas11, 0);
        preguntas.add(p);
        
        
                
        String[] respuestas12 = {
            "nombre_metodo variable = new nombre_variable",
            "nombre_metodo variable = nombre_variable",
            "nombre_metodo variable = new nombre_metodo",
            "Todas las anteriores"
        };
        
        p = new Pregunta("Para inicializar o ejecutar un programa se escribe dentro del void main:", respuestas12, 2);
        preguntas.add(p);
        
        return preguntas;
    }
    
    public void borrar( int indice, Dificultad dificultad ){
        if( dificultad == Dificultad.FACIL )
            this.preguntasFaciles.remove(indice);
        else 
            this.preguntasIntermedias.remove(indice);
    }
    
    public void nueva( Pregunta pregunta,Dificultad dificultad) {  
        switch ( dificultad ) {
            case FACIL: preguntasFaciles.add(pregunta);
                System.err.println(preguntasFaciles.toString());
                break;
            case INTERMEDIA: preguntasIntermedias.add(pregunta);
            System.err.println(preguntasIntermedias.toString());
                break;
            default: 
        }
    }
    
    public void modificar( Pregunta p, int indice, Dificultad dif ){
        if( dif == Dificultad.FACIL ) this.preguntasFaciles.set(indice, p);
        else if(dif == Dificultad.INTERMEDIA ) this.preguntasIntermedias.set(indice, p);
    }
}
