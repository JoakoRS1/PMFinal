package com.example.pmfinal.settings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pmfinal.Constantes
import com.example.pmfinal.MainActivity
import com.example.pmfinal.R
import org.w3c.dom.Text
import kotlin.math.round
import kotlin.math.roundToInt

class perfilFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settingsperfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var butActualizar = view.findViewById<Button>(R.id.bActualizar)
        var eteNombre= view.findViewById<EditText>(R.id.eteNombre)
        var eteGenero= view.findViewById<EditText>(R.id.eteGenero)
        var eteAltura= view.findViewById<EditText>(R.id.eteAltura)
        var eteEdad= view.findViewById<EditText>(R.id.eteEdad)
        var etePeso= view.findViewById<EditText>(R.id.etePeso)


        val sp = requireActivity().getSharedPreferences(Constantes.NOMBRE_SP, Context.MODE_PRIVATE)
        val username = sp.getString(Constantes.SP_USERNAME, "")
        val genero = sp.getString(Constantes.SP_GENERO, "")
        val edad = sp.getString(Constantes.SP_EDAD, "")
        val peso = sp.getString(Constantes.SP_PESO, "")
        val altura = sp.getString(Constantes.SP_ALTURA, "")
        var tViIMC2= view.findViewById<TextView>(R.id.tViIMC2)

        etePeso.text

        val imc = (peso!!.toFloat()/(altura!!.toFloat()*altura.toFloat())* 100.00).roundToInt()/100.00
        Log.i("imc", imc.toString())

        eteNombre.setText(username)
        eteGenero.setText(genero)
        eteAltura.setText(altura)
        eteEdad.setText(edad)
        etePeso.setText(peso)
        tViIMC2.setText(imc.toString())


        butActualizar.setOnClickListener {
            guardar(eteNombre.text.toString(), Constantes.SP_USERNAME)
            guardar(eteGenero.text.toString(), Constantes.SP_GENERO)
            guardar(eteAltura.text.toString(), Constantes.SP_ALTURA)
            guardar(eteEdad.text.toString(), Constantes.SP_EDAD)
            guardar(etePeso.text.toString(), Constantes.SP_PESO)

            var tViIMCN= view.findViewById<TextView>(R.id.tViIMC2)

            val pesoN = sp.getString(Constantes.SP_PESO, "")
            val alturaN = sp.getString(Constantes.SP_ALTURA, "")
            val imcN = (pesoN!!.toFloat()/(alturaN!!.toFloat()*alturaN.toFloat())* 100.00).roundToInt()/100.00

            tViIMCN.setText(imcN.toString())

            Toast.makeText(context, "Actualizado!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun guardar(valor: String, constante: String) {
        val editor = requireActivity().getSharedPreferences(
            Constantes.NOMBRE_SP,
            AppCompatActivity.MODE_PRIVATE
        ).edit()
        editor.putString(constante, valor)
        editor.commit()
    }


}