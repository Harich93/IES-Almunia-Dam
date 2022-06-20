/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author beni-
 */
public class Pregunta {
    
    private int id;
    private String cuestion = "";
    private String[] respuestas;
    private Integer respuestaCorrecta;
    private int dificultad;
    
    public Pregunta( String cuestion, String[] respuestas, Integer correcta){
        this.cuestion = cuestion;
        this.respuestas = respuestas;
        this.respuestaCorrecta = correcta;
    }
    
    public Pregunta(){
        
    };

    public int getId(){
        return this.id;
    }
    
    public int getDificultad() {
        return this.dificultad;
    }
    
    public String getCuestion() {
        return cuestion;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public Integer getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    
    public void setId( int id ) {
        this.id = id;
    }

    public void setCuestion(String cuestion) {
        this.cuestion = cuestion;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public void setRespuestaCorrecta(Integer respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    public void setDificultad( int dificultad ) {
        this.dificultad = dificultad;
    }
    
    public boolean comprobar( int respuesta) {
       
        if( respuesta == this.respuestaCorrecta ) return true;
        
        return false;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "cuestion=" + cuestion + ", respuestas=" + respuestas + ", respuestaCorrecta=" + respuestaCorrecta + '}';
    }
    
    
}
