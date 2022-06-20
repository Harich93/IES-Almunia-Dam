package com.example.apppreguntas.ui.test

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.apppreguntas.databinding.FragmentTestsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TestFragment : Fragment() {

    var user = FirebaseAuth.getInstance().currentUser
    private val db = Firebase.firestore
    private var _binding: FragmentTestsBinding? = null
    private val binding get() = _binding!!

    private lateinit var spinnerCat: Spinner
    private lateinit var categorias: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTestsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        init()
        return root
    }

    private fun init() {
        spinnerCat = binding.spinnerCategoria
        binding.btnModCat.setOnClickListener{
            goModCategoria(it)
        }
        binding.btnCrearTest.setOnClickListener {
            goCreateCategoria(it)
        }
        adapterCategorias()

    }

    private fun getCategorias(): List<String> {

        categorias = mutableListOf("Seleccione categoria")

        db.collection("categoriasUser")
            .document(user!!.uid)
            .collection("categorias")
            .get()
            .addOnSuccessListener { result ->
                for (document in result)
                    categorias.add(document["categoria"] as String)
            }
            .addOnFailureListener {Log.w("FirebaseError",it.toString())}
        return categorias
    }

    private fun adapterCategorias() {

        ArrayAdapter(
            requireActivity().baseContext,
            android.R.layout.simple_spinner_item,
            getCategorias()

        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCat.adapter = adapter
        }

    }

    private fun goCreateCategoria( view: View ) {
        var nomCategoria = binding.txtNomCategoria.text.toString()

        if( nomCategoria.isEmpty() ) {
            alert("Debe de dar un nombre de categoria al cuestionario","¡Nombre vacío!")
        }
        else if( categorias.contains(nomCategoria)) {
            alert("La categoria ya existe pruebe con otro nombre","¡Categoria ya existe!")
        }
        else {
            val intent = Intent( requireActivity().baseContext, CreateCategoryActivity::class.java )
            intent.putExtra("categoria", nomCategoria)
            startActivity(intent)
        }


    }

    private fun goModCategoria( view: View ) {

        if( spinnerCat.selectedItem.toString() == "Seleccione categoria") {
            alert("Debe elegir una categoria para modificar","¡Categoria no seleccionada!")
        }
        else {
            var categoria = spinnerCat.selectedItem.toString()
            Log.i("categoria",categoria)
            val intent = Intent( requireActivity().baseContext, ModTestActivity::class.java )
            intent.putExtra("categoria", categoria )
            startActivity(intent)
        }

    }

    private fun alert( msg: String, title: String ) {
        AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("Ok") { _,_ -> }
            .create()
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
