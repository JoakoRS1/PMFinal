package com.example.pmfinal.IntroFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pmfinal.Constantes
import com.example.pmfinal.R

class Slide4Fragment : Fragment() {
    private val fragmentslide = Slide5Fragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Slide2"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.slide_4, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var butNext= view.findViewById<Button>(R.id.button)
        var etName= view.findViewById<EditText>(R.id.editTextNumberDecimal)

        butNext.setOnClickListener{
            if (etName.text.toString() != ""){
                //guardar nombre
                //ir a siguiente slide
                    guardarAlturaSP(etName.text.toString())
                val ft = requireActivity().supportFragmentManager?.beginTransaction()
                ft.replace(R.id.fcvIntro, fragmentslide)
                ft.addToBackStack(null)
                ft.commit()
            }
            else{
                Toast.makeText(context, "Ingresar valor altura", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun guardarAlturaSP(altura: String) {
        val editor = requireActivity().getSharedPreferences(
            Constantes.NOMBRE_SP,
            AppCompatActivity.MODE_PRIVATE
        ).edit()
        editor.putString(Constantes.SP_ALTURA, altura)
        editor.commit()
    }
}