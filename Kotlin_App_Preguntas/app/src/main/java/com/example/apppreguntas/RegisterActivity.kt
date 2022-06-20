package com.example.apppreguntas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var txtName: EditText;
    private lateinit var txtEmail: EditText;
    private lateinit var txtPass: EditText;

    private lateinit var name: String;
    private lateinit var email: String;
    private lateinit var pass: String;

    private lateinit var progressBar: ProgressBar
    private val db = Firebase.firestore
    private var auth = Firebase.auth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.elevation = 0F
        title = "Register"

        init()

    }

    private fun init(){
        txtName = findViewById(R.id.txtName)
        txtEmail = findViewById(R.id.txtEmailRegister)
        txtPass = findViewById(R.id.txtPassRegister)
    }

    fun registrar( view: View ) {

        name = txtName.text.toString()
        email = txtEmail.text.toString()
        pass = txtPass.text.toString()

        lateinit var user: HashMap<String, Any>

        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener(this) {

                val userAuth = auth.currentUser!!

                user = hashMapOf(
                    "name" to name,
                    "email" to email
                )

                db.collection("users")
                    .document(userAuth.uid)
                    .set(user)
                    .addOnSuccessListener { documentReference ->
                        val intent = Intent(this, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                    }
                    .addOnFailureListener { e ->

                    }
            }


    }




    fun goLogin( view: View) {
        var intent = Intent( this, LoginActivity::class.java )
        startActivity( intent )
    }
}