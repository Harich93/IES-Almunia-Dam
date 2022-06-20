package com.example.apppreguntas.ui.test

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apppreguntas.R
import com.example.apppreguntas.models.Pregunta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CreateCategoryActivity : AppCompatActivity() {

    private var extras: Bundle? = null
    private var preguntas = mutableListOf<Pregunta>()

//    Firebase
    var db = Firebase.firestore
    var user = FirebaseAuth.getInstance().currentUser


//    Controllers Vista
    private lateinit var btnTerminar: Button
    private lateinit var btnCrearNueva: Button
    private lateinit var cuestion: EditText
    private lateinit var groupRes: RadioGroup
    private lateinit var res1: EditText
    private lateinit var res2: EditText
    private lateinit var res3: EditText
    private lateinit var res4: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_category)
        init()

        title = extras!!.getString("categoria")
            .toString()
            .uppercase()

        crearCategoria()
    }


    private fun init() {
        extras = intent.extras
        cuestion = findViewById( R.id.txtCuestionNueva )
        groupRes = findViewById( R.id.rbGroupResNueva )
        res1 = findViewById( R.id.txtRes1Nueva )
        res2 = findViewById( R.id.txtRes2Nueva )
        res3 = findViewById( R.id.txtRes3Nueva )
        res4 = findViewById( R.id.txtRes4Nueva )
        btnTerminar = findViewById( R.id.btnTerminar )
        btnCrearNueva = findViewById( R.id.btnCrearNueva )


        btnTerminar.setOnClickListener { crearCuestionario(it) }
        btnCrearNueva.setOnClickListener { siguientePregunta(it) }

    }

    private fun crearCategoria(){

        var categoria = hashMapOf<String,Any>(
            "categoria" to extras!!.getString("categoria").toString(),
        )

        db.collection("categoriasUser")
            .document(user!!.uid)
            .collection("categorias")
            .add(categoria)
            .addOnSuccessListener { finishActivity(this.hashCode())

            }
            .addOnFailureListener {Log.w("FirebaseError",it.toString())}
    }

    private fun crearCuestionario( view: View ) {

        if( comprobarCampos() ){
            guardarPregunta()
            borrarCampos()
        }

        preguntas.forEach {

            var pregunta = hashMapOf<String,Any>(
                "categoria" to extras!!.getString("categoria").toString(),
                "correcta" to it.correcta,
                "cuestion" to it.cuestion,
                "respuestas" to it.respuestas
            )

            db.collection("preguntasUser")
                .document(user!!.uid)
                .collection("preguntas")
                .add(pregunta)
                .addOnSuccessListener {
                    onBackPressed()
                    finish()
                }
                .addOnFailureListener {Log.w("FirebaseError", it.toString())}

        }

        finish()

    }

    private fun siguientePregunta( view: View ) {
        if( !comprobarCampos() ) {
            guardarPregunta()
            borrarCampos()
        }
    }

    private fun guardarPregunta(){

        var categoria = extras!!.getString("categoria").toString()
        var correcta =  checkRbIndex(groupRes.checkedRadioButtonId)
        var cuestion = cuestion.text.toString()
        var respuestas: ArrayList<String> = ArrayList()
        respuestas.add(res1.text.toString())
        respuestas.add(res2.text.toString())
        respuestas.add(res3.text.toString())
        respuestas.add(res4.text.toString())


        preguntas.add(Pregunta(
            cuestion,
            respuestas,
            correcta,
            categoria
        ))
    }

    private fun comprobarCampos(): Boolean {

        var error = false

        if( cuestion.text.isEmpty() ) {
            faltanCampos("La cuestión esta vacía")
            error = true
        }
        else if ( res1.text.isEmpty() ){
            faltanCampos("La respuesta 1 esta vacía")
            error = true
        }
        else if ( res2.text.isEmpty() ){
            faltanCampos("La respuesta 2 esta vacía")
            error = true
        }
        else if ( res3.text.isEmpty() ){
            faltanCampos("La respuesta 3 esta vacía")
            error = true
        }
        else if ( res4.text.isEmpty() ){
            faltanCampos("La respuesta 4 esta vacía")
            error = true
        }
        else if( groupRes.checkedRadioButtonId == null) {
            faltanCampos("No se ha seleccionado la correcta")
            error = true
        }

        return error
    }

    private fun borrarCampos(){
        cuestion.setText("")
        groupRes.check(0)
        res1.setText("")
        res2.setText("")
        res3.setText("")
        res4.setText("")
    }

    private fun faltanCampos(msg: String) {
        val toast = Toast.makeText(this, "Mensaje 1", Toast.LENGTH_SHORT)
        toast.show()
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