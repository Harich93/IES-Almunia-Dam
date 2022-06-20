package com.example.apppreguntas.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.apppreguntas.R
import com.example.apppreguntas.models.Pregunta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ModPreguntaActivity : AppCompatActivity() {

    private var user = FirebaseAuth.getInstance().currentUser
    private val db = Firebase.firestore
    lateinit var idPregunta: String
    private var extras: Bundle? = null

    private lateinit var pregunta: Pregunta
    private lateinit var cuestion: EditText
    private lateinit var groupRes: RadioGroup
    private lateinit var res1: EditText
    private lateinit var res2: EditText
    private lateinit var res3: EditText
    private lateinit var res4: EditText

    private lateinit var btnGuardar: Button
    private var isNew: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mod_pregunta)

        init()
        isNew = isNewPregunta()
    }


    private fun init(){

        extras = intent.extras
        cuestion = findViewById( R.id.txtCuestion )
        groupRes = findViewById( R.id.rbGroupRes )
        res1 = findViewById( R.id.txtRes1 )
        res2 = findViewById( R.id.txtRes2 )
        res3 = findViewById( R.id.txtRes3 )
        res4 = findViewById( R.id.txtRes4 )
        btnGuardar = findViewById( R.id.btnTerminar )
        btnGuardar.setOnClickListener{ guardar(it) }

    }

    private fun isNewPregunta(): Boolean{

        if( extras != null  ) {

            title = extras!!.getString("titulo")

            if( !extras!!.getBoolean("new") ){
                idPregunta = extras!!.getString("id").toString()
                title = extras!!.getString("titulo")

                getPregunta()

                return false
            }

        }

        return true
    }

    private fun getPregunta() {

        val respuestas = mutableListOf<String>()

        db.collection("preguntasUser")
            .document(user!!.uid)
            .collection("preguntas")
            .document(idPregunta)
            .get()
            .addOnSuccessListener { d->
                var aux: ArrayList<String> = d["respuestas"] as ArrayList<String>
                aux.forEach{ respuestas.add(it)}
                pregunta = Pregunta(d.id, d["cuestion"]as String, respuestas, d["correcta"].toString().toInt(), d["categoria"] as String)
                rellenarCampos(pregunta)
            }

            .addOnFailureListener {Log.w("FirebaseError",it.toString())}
    }

    private fun guardar(view: View){

        var categoria = extras!!.getString("titulo").toString()
        var aux: ArrayList<String> = ArrayList()
        aux.add(res1.text.toString())
        aux.add(res2.text.toString())
        aux.add(res3.text.toString())
        aux.add(res4.text.toString())

        var p= hashMapOf<String,Any>(
                "categoria" to categoria,
                "correcta" to checkRbIndex(groupRes.checkedRadioButtonId),
                "cuestion" to cuestion.text.toString(),
                "respuestas" to aux.toList()
            )

        if( isNew ){
            crearNuevaPregunta(p)
        }
        else {
            actualizarPregunta(p)
        }

    }

    private fun crearNuevaPregunta(p: HashMap<String, Any>){
        db.collection("preguntasUser")
            .document(user!!.uid)
            .collection("preguntas")
            .add(p)
            .addOnSuccessListener { finishActivity(this.hashCode())
                ModTestActivity().recreate()
                finish()
            }
            .addOnFailureListener {Log.w("FirebaseError",it.toString())}
    }

    private fun actualizarPregunta( p: HashMap<String, Any>){
        db.collection("preguntasUser")
            .document(user!!.uid)
            .collection("preguntas")
            .document(idPregunta)
            .update(p)
            .addOnSuccessListener { finishActivity(this.hashCode())
                ModTestActivity().recreate()
                finish()
            }
            .addOnFailureListener {Log.w("FirebaseError",it.toString())}
    }

    private fun rellenarCampos( pregunta: Pregunta ) {
        cuestion.setText(pregunta.cuestion)
        res1.setText(pregunta.respuestas[0])
        res2.setText(pregunta.respuestas[1])
        res3.setText(pregunta.respuestas[2])
        res4.setText(pregunta.respuestas[3])

        groupRes.check(checkRb(pregunta.correcta))
    }

    private fun checkRb( ind: Int ): Int {
        return when(ind) {
            0 -> R.id.rbRes0
            1 -> R.id.rbRes1
            2 -> R.id.rbRes2
            3 -> R.id.rbRes3
            else -> R.id.rbRes0
        }
    }

    private fun checkRbIndex( id: Int): Int {
        return when(id) {
              R.id.rbRes0 -> 0
              R.id.rbRes1 -> 1
              R.id.rbRes2 -> 2
              R.id.rbRes3 -> 3
            else -> 0
        }
    }
}