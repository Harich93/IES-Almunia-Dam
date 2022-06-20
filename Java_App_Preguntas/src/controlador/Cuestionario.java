/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import daos.DAOCuestionario;
import enums.Dificultad;
import clases.Pregunta;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author beni-
 */
public class Cuestionario {
    
    DAOCuestionario dao;
   
    private boolean finTest = false;
    private int aciertos = 0;
    private int nPreguntasAleatorias = 5;
    private int indPregunta = 1;
    
    
    private Dificultad dificultad;
    private ArrayList<Pregunta> preguntasFaciles ;
    private ArrayList<Pregunta> preguntasIntermedias;
    private ArrayList<Pregunta> preguntasAleatorias;
    private Pregunta preguntaActiva;
    
    
    //<-- Constructor -->
    public Cuestionario() {
        dao = DAOCuestionario.getDAOCuestionario();
        dificultad = Dificultad.FACIL;
        preguntasFaciles = dao.getPreguntas(1);
        preguntasIntermedias = dao.getPreguntas(2);
        preguntaActiva = preguntasFaciles.get(0);
    }
    
   
    
    // <-- Getters -->
    public Dificultad getDificultad(){
        return this.dificultad;
    }
    
    public int getIndicePregunta(){
        return this.indPregunta;
    }
    
    public void setIndicePregunta( int indice ){
        this.indPregunta = indice;
    }
    
    public boolean getFinTest(){
        return this.finTest;
    }
    
    public ArrayList<Pregunta> getListaPreguntas() {
        
        if( this.dificultad == Dificultad.FACIL)
            return this.preguntasFaciles;
       
        else if ( this.dificultad == Dificultad.INTERMEDIA )
            return this.preguntasIntermedias;
       
        else 
            return this.preguntasAleatorias;
    }
    
    public ArrayList<Pregunta> getPregunta() {
        
        if ( dificultad == Dificultad.INTERMEDIA ) return preguntasIntermedias;
        
        if( dificultad == Dificultad.ALEATORIA ) {
            preguntasAleatorias = this.generarAleatorias();

            return preguntasAleatorias;
        }
         
        return preguntasFaciles;
        
    }

    public int getAciertos() {
        return aciertos;
    }
    
    public Pregunta getPreguntaActiva() {
        return preguntaActiva;
    }
    
    
    //<-- Setters -->
    public void setDificultad( Dificultad dificultad ){
        this.dificultad = dificultad;
    }
    
    public void setNPreguntasAleatorias( int numero ){
        this.nPreguntasAleatorias = numero;
    }
    
    
    
    //<-- Auxiliares -->
    private ArrayList<Pregunta> generarAleatorias() {
        
        ArrayList<Pregunta> aleatorias = new ArrayList();
        ArrayList<Pregunta> aleatoriasFinal = new ArrayList();
        
        aleatorias.addAll(preguntasFaciles);
        aleatorias.addAll(preguntasIntermedias);
        
        do {
            
            Random random = new Random();
            
            int ale = random.nextInt(aleatorias.size() - 0 ) + 0;
            aleatoriasFinal.add(aleatorias.get(ale));
            aleatorias.remove(ale);
            
        }while (aleatoriasFinal.size() != nPreguntasAleatorias);  
            
        
        return aleatoriasFinal;
    }
    
    public void siguientePregunta( ){
       
        ArrayList<Pregunta> preguntas;
        
        switch (this.dificultad) {
            case FACIL:
                preguntas = this.preguntasFaciles;
                break;
            case ALEATORIA:
                preguntas = this.preguntasAleatorias;
                break;
            default:
                preguntas = this.preguntasIntermedias;
                break;
        }
        
        if( indPregunta < preguntas.size() ){
            this.preguntaActiva = preguntas.get(indPregunta );
            indPregunta++;            
        }
    }

    public boolean verificarRespuesta( int respuesta ){
        if( preguntaActiva.comprobar(respuesta)) {
            this.aciertos++;
            return true;
        }   
        return false;
    }
    
    public void finTest(){
        this.finTest = true;
        this.resetTest();
    }
    
    public void resetTest(){
        this.preguntaActiva = this.getListaPreguntas().get(0);
        this.aciertos = 0;
        indPregunta = 0; 
    }
    
   
    //<-- CRUD -->
    
    public ArrayList<String> getCuestiones(){
        
        ArrayList<String> cuestiones = new ArrayList();
        
        for(Pregunta pregunta : this.getListaPreguntas() )
            cuestiones.add(pregunta.getCuestion());
        
        return cuestiones;
    }
    
    public void borrar( Pregunta p ){
        dao.borrar( p );
        refrescoLista(p);
    }
    
    public void nueva( Pregunta nuevaPregunta, Dificultad dificultad ){
        dao.nueva(nuevaPregunta);
        refrescoLista(nuevaPregunta);
    }
    
    public void modificar( Pregunta pregunta ){
       dao.modificar(pregunta);
        refrescoLista(pregunta);
    }
    
    public void refrescoLista( Pregunta p) {
            if( p.getDificultad() ==  1 ) 
            this.preguntasFaciles = dao.getPreguntas(1);
            else this.preguntasIntermedias = dao.getPreguntas(2);  
    }
    
    public void cerrarConexion() {
        dao.cerrarConexion();
    }
    
    
    
    
    
    
    
    
}
