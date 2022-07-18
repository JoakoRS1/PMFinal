package com.example.pmfinal.IntroFragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pmfinal.Constantes
import com.example.pmfinal.MainActivity
import com.example.pmfinal.R

class Slide5Fragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Slide5"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.slide_5, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var butNext= view.findViewById<Button>(R.id.button)
        var tvuserName= view.findViewById<TextView>(R.id.tvUserName)
        var tvGenero= view.findViewById<TextView>(R.id.tvGenero)
        //var tvEdad= view.findViewById<TextView>(R.id.tvEdad)
        var tvPeso= view.findViewById<TextView>(R.id.tvPeso)
        var tvAltura= view.findViewById<TextView>(R.id.tvAltura)

        val sp = requireActivity().getSharedPreferences(Constantes.NOMBRE_SP, Context.MODE_PRIVATE)
        val username = sp.getString(Constantes.SP_USERNAME, "")
        val genero = sp.getString(Constantes.SP_GENERO, "")
        //val edad = sp.getString(Constantes.SP_EDAD, "")
        val peso = sp.getString(Constantes.SP_PESO, "")
        val altura = sp.getString(Constantes.SP_ALTURA, "")


        tvuserName.setText(username)
        tvGenero.setText(genero)
        //tvEdad.setText(edad)
        tvAltura.setText(altura)
        tvPeso.setText(peso)



        butNext.setOnClickListener{
            Toast.makeText(context, "Datos ingresados completamente.", Toast.LENGTH_SHORT).show()


            val i = Intent(getActivity(), MainActivity::class.java)
            startActivity(i)
            (getActivity() as Activity).overridePendingTransition(0, 0)
        }
    }
}