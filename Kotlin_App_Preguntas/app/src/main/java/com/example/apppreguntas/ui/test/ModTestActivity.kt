package com.example.apppreguntas.ui.test


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppreguntas.R
import com.example.apppreguntas.adapters.RecyclerAdapter
import com.example.apppreguntas.models.Pregunta
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ModTestActivity : AppCompatActivity() {

    private val db = Firebase.firestore
    var user = FirebaseAuth.getInstance().currentUser

    private var extras: Bundle? = null

    private var preguntas: MutableList< Pregunta > = mutableListOf()
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()
    lateinit var btnAdd: FloatingActionButton

    override fun recreate() {
        super.recreate()
        getPreguntas()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mod_test)

        preguntas = getPreguntas()
        btnAdd = findViewById(R.id.btnAddPregunta)
        btnAdd.setOnClickListener { crearPregunta(it) }
        extras = intent.extras
        title = extras!!.getString("categoria")
            .toString()
            .uppercase()

    }

    private fun getPreguntas(): MutableList<Pregunta> {

        var preguntas = mutableListOf<Pregunta>()
        val respuestas = mutableListOf<String>()

        db.collection("preguntasUser")
            .document(user!!.uid)
            .collection("preguntas")
            .get()
            .addOnSuccessListener { result ->
                for ( d in result) {
                    if( d["categoria"] == extras!!.getString("categoria") ){

                        var aux: ArrayList<String> = d.data["respuestas"] as ArrayList<String>
                        aux.forEach{ respuestas.add(it) }

                        preguntas.add(Pregunta(
                                d.id,
                                d["cuestion"] as String,
                                respuestas,
                                d["correcta"].toString().toInt(),
                                d["categoria"] as String
                        ))
                    }

                }

                setUpRecyclerView(preguntas)
            }
            .addOnFailureListener { exception ->
                Log.i("categoria", "Error getting documents.", exception)
            }

        return preguntas
    }

    fun crearPregunta( view: View ){
        val intent = Intent(this, ModPreguntaActivity::class.java)
        intent.putExtra("titulo", extras!!.getString("categoria"))
        intent.putExtra("new", true)

        startActivity(intent)
    }
    fun setUpRecyclerView( list: MutableList<Pregunta> ){
        mRecyclerView = findViewById(R.id.rvPreguntas) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(list, this )
        mRecyclerView.adapter = mAdapter
    }


}