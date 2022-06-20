package com.example.apppreguntas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private val auth = Firebase.auth
    var user = FirebaseAuth.getInstance().currentUser
    private lateinit var btnLogin: Button


    lateinit private var email: String
    lateinit private var pass: String

    lateinit private var txtEmail: EditText
    lateinit private var txtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.elevation = 0F
        title = "Login"

        btnLogin = findViewById(R.id.btnLogin)
        txtEmail = findViewById(R.id.txtEmail)
        txtPass = findViewById(R.id.txtPass)


    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)




    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            findViewById<Button>(R.id.btnLogin).visibility = View.VISIBLE
        } else {
            findViewById<View>(R.id.btnLogin).visibility = View.GONE
        }
    }

    fun login( view: View ) {

        email = txtEmail.text.toString()
        pass = txtPass.text.toString()

        btnLogin.isEnabled = false

        auth.signInWithEmailAndPassword(email,pass)
            .addOnSuccessListener {
                Log.i("UserConnected", user!!.uid)
                var intent = Intent( this, HomeActivity::class.java )
                startActivity( intent )
            }
            .addOnFailureListener {
                btnLogin.isEnabled = true
                val toast = Toast.makeText(this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT)
                toast.show()
            }

    }

    fun goRegister( view: View ) {
        var intent = Intent( this, RegisterActivity::class.java )
        startActivity( intent )
    }
}