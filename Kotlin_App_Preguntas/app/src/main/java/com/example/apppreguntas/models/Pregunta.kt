package com.example.apppreguntas.models

import android.content.Intent
import com.example.apppreguntas.HomeActivity
import com.example.apppreguntas.ui.test.ModTestActivity

class Pregunta(id: String, cuestion: String, respuestas: MutableList<String>, correcta: Int, categoria: String) {

    var id = id
    var cuestion = cuestion
    var respuestas = respuestas
    var correcta: Int = correcta
    var categoria = categoria

    constructor(cuestion: String, respuestas: MutableList<String>, correcta: Int, categoria: String)
            : this("0",cuestion,respuestas,correcta,categoria)



    fun comprobar(respuesta: Int): Boolean {
        return if (respuesta == correcta) true else false
    }

    fun goModActivity(){
        val intent = Intent( ModTestActivity().applicationContext, HomeActivity::class.java )
        ModTestActivity().startActivity(intent)
    }

    override fun toString(): String {
        return "Pregunta{cuestion=$cuestion, respuestas=$respuestas, respuestaCorrecta=$correcta}"
    }

}