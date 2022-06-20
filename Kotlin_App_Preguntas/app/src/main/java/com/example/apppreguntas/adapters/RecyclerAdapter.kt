package com.example.apppreguntas.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.apppreguntas.R
import com.example.apppreguntas.models.Pregunta
import com.example.apppreguntas.ui.test.ModPreguntaActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.properties.Delegates


class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    var preguntas: MutableList<Pregunta> = ArrayList()
    lateinit var context: Context


    fun RecyclerAdapter(preguntas : MutableList<Pregunta>, context: Context){
        this.preguntas = preguntas
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = preguntas.get(position)
        holder.bind(item, context, position)
        holder.setOnClickListeners()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.card_pregunta_mod, parent, false))
    }

    override fun getItemCount(): Int {
        return preguntas.size
    }

    fun deleteItem(index: Int){
        preguntas.removeAt(index)
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

//        Firebase
        private var user = FirebaseAuth.getInstance().currentUser
        private val db = Firebase.firestore


//        Adapter
        var context = view.context
        var index by Delegates.notNull<Int>()
        var idPregunta: String = ""


//        Card
        var btnEditar = view.findViewById<Button>( R.id.card_button_editar)
        var btnEliminar = view.findViewById<Button>( R.id.card_button_eliminar)
        var card = view.findViewById<CardView>( R.id.card_pregunta)
        val titulo = view.findViewById(R.id.titulo_card) as TextView
        val cuestion = view.findViewById(R.id.cuestion_card) as TextView


        fun bind(pregunta: Pregunta, context: Context, position: Int){
            index = position
            cuestion.text = pregunta.cuestion
            idPregunta = pregunta.id
            titulo.text =  "Pregunta ${pregunta.categoria}"
        }

        fun setOnClickListeners(){
            btnEditar.setOnClickListener(this)
            btnEliminar.setOnClickListener(this)
            card.setOnClickListener(this,)
        }

        private fun alert( msg: String, title: String, position: Int ) {

            AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("Ok") { _,_ ->
                    run {
                        db.collection("preguntasUser")
                            .document(user!!.uid)
                            .collection("preguntas")
                            .document(idPregunta)
                            .delete()
                            .addOnSuccessListener { deleteItem(position) }
                    }
                }
                .setNegativeButton("Cancel") { _,_ -> }
                .create()
                .show()
        }

        override fun onClick(view: View) {

            when(view.id) {
                R.id.card_button_editar -> {
                    var intent = Intent(context, ModPreguntaActivity::class.java )
                    intent.putExtra("id", idPregunta)
                    intent.putExtra("titulo", titulo.text)
                    intent.putExtra("new", false)
                    context.startActivity( intent )

                }

                R.id.card_button_eliminar -> {
                    alert("Desea eliminar la pregunta", "Eliminar", index)


                }

            }
        }

    }

}

