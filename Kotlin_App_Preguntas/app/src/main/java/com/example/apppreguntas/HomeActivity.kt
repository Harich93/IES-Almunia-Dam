package com.example.apppreguntas

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.apppreguntas.databinding.ActivityHomeBinding
import com.example.apppreguntas.models.Pregunta
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomeActivity : AppCompatActivity() {

    var user = FirebaseAuth.getInstance().currentUser
    private val db = Firebase.firestore
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarHome.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_home)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_quest, R.id.nav_ajustes, R.id.btnModCat
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_home)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



    private fun Preguntas() {

        val preguntas: ArrayList<Pregunta> = ArrayList()
        val respuestas1 = mutableListOf<String>(
            "ng make component mi-componente",
            "ng extend component mi-componente",
            "ng create component mi-componente",
            "ng generate component mi-componente"
        )

        var p = Pregunta("¿Qué comando de Angular CLI debo utilizar para crear un componente llamado mi-componente?", respuestas1, 3,"angular")
        preguntas.add(p!!)


        val respuestas2 = mutableListOf<String>(
            "Propiedades Input (entrada) y output (salida).",
            "Sus «lifecycle hooks» (ciclo de vida) y su interacción con el elemento anfitrión (host).",
            "Un componente no tiene nada parecido a una API privada.",
            "Ninguna es correcta"
        )

        p = Pregunta(" La API privada de un componente está compuesta por:", respuestas2, 0,"angular")
        preguntas.add(p)


        val respuestas3 = mutableListOf<String>(
            "Para extender una función mediante otra función, pero sin tocar la original, que se está extendiendo.",
            "Para modificar CSS mediante funciones JS.",
            "Para modificar HTML mediante funciones JS.",
            "Todas son correctas"
        )

        p = Pregunta("¿Para qué sirve un decorador?",respuestas3,0, "angular")
        preguntas.add(p)


        val respuestas4 = mutableListOf<String>(
            "Input (entrada) y Output (salida)",
            "Input (entrada) y Source (fuente)",
            "Input (entrada) y Scope (alcance)",
            "Input (entrada) y Type (tipo)"
        )

        p = Pregunta("¿Qué propiedades funcionan como la API pública de un componente en Angular 2?", respuestas4, 0,"angular")
        preguntas.add(p)


//        val respuestas5 = arrayOf(
//            "Capturar datos del mouse",
//            "Capturar fotos",
//            "Capturar pantallazos",
//            "Capturar datos por teclado"
//        )
//
//        p = Pregunta("Scanner teclado=new Scanner(System.in); permite:", respuestas5, 3,"java")
//        preguntas.add(p)
//
//
//        val respuestas6 = arrayOf(
//            "public Class",
//            "package",
//            "void main",
//            "metodo"
//        )
//
//        p = Pregunta("Las librerias se llaman dentro de: ", respuestas6, 1,"java")
//        preguntas.add(p)
//
//
//        val respuestas7 = arrayOf(
//            "Asignar a la variable caja un cuadro de texto",
//            "Asignar a la variable caja un circulo",
//            "Asignar a la variable caja datos numericos",
//            "Todas son correctas"
//        )
//
//        p = Pregunta("La linea, caja = new JTextField(); permite", respuestas7, 0,"java")
//        preguntas.add(p)
//
//
//        val respuestas8 = arrayOf(
//            "Crear marcos o ventanas",
//            "Crear elipses",
//            "Crear grillas",
//            "Ninguna de las anteriores"
//        )
//
//        p = Pregunta("JFrame permite: ", respuestas8, 0,"java")
//        preguntas.add(p)
//
//
//        val respuestas9 = arrayOf(
//            "Si",
//            "No",
//            "Las dos anteriores",
//            "Ninguna de las anteriores"
//        )
//
//        p = Pregunta("¿ Es correcto escribir: int a,b; String Suma, ?", respuestas9, 1,"java")
//        preguntas.add(p)
//
//
//        val respuestas10 = arrayOf(
//            "Agregar el nombre del programa en la barra de titulo",
//            "Agregar el nombre en la barra de estado",
//            "Agregar el nombre del programa en la ventana de comandos",
//            "Cerrar el programa"
//        )
//
//        p = Pregunta("la linea, super (\"Crepusculo\"); permite:", respuestas10, 0,"java")
//        preguntas.add(p)
//
//
//        val respuestas11 = arrayOf(
//            "Mostrar una ventana que permite capturar datos ingresados por teclado",
//            "Mostrar una ventana que permite desplegar datos",
//            "mostrar datos desde consola",
//            "Todas las anteriores"
//        )
//
//        p = Pregunta("JOptionPane.showInputDialoge permite", respuestas11, 0,"java")
//        preguntas.add(p)
//
//
//        val respuestas12 = arrayOf(
//            "nombre_metodo variable = new nombre_variable",
//            "nombre_metodo variable = nombre_variable",
//            "nombre_metodo variable = new nombre_metodo",
//            "Todas las anteriores"
//        )
//
//        p = Pregunta(
//            "Para inicializar o ejecutar un programa se escribe dentro del void main:",
//            respuestas12,
//            2,
//            "java"
//        )
//        preguntas.add(p)
//
        preguntas.forEach {

            var pregunta = hashMapOf(
                "categoria" to it.categoria,
                "correcta" to it.correcta,
                "cuestion" to it.cuestion,
                "respuestas" to it.respuestas.toList()
            )

            db.collection("preguntasUser")
                .document(user!!.uid)
                .collection("preguntas")
                .add(pregunta)
                .addOnSuccessListener { documentReference ->
                    Log.i("Pregunta add", "Ok")
                }
                .addOnFailureListener { e ->
                    Log.i("Pregunta add", "Fail")

                }
        }
    }





}