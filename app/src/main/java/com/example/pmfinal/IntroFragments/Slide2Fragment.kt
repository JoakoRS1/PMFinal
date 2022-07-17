package com.example.pmfinal.IntroFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pmfinal.Constantes
import com.example.pmfinal.R

class Slide2Fragment : Fragment(){
    private val fragmentslide = Slide3Fragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Slide2"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.slide_2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var butNext= view.findViewById<Button>(R.id.button)
        var rbGroup= view.findViewById<RadioGroup>(R.id.radioGroup)

        butNext.setOnClickListener{
            var option=view.findViewById<RadioButton>(rbGroup.checkedRadioButtonId)
            if (option!=null){
                Toast.makeText(context, option.text, Toast.LENGTH_SHORT).show()
                var genero = option.text.toString()
                if (genero=="Prefiero no decir") {
                    genero = "indefinido"
                }
                    //guardar género
                guardarGeneroSP(genero)
                    //ir a siguiente slide
                val ft = requireActivity().supportFragmentManager?.beginTransaction()
                ft!!.replace(R.id.fcvIntro, fragmentslide)
                ft!!.addToBackStack(null)
                ft!!.commit()
            }
            else{
                Toast.makeText(context, "Selecciona una opción.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun guardarGeneroSP(genero: String) {
        val editor = requireActivity().getSharedPreferences(
            Constantes.NOMBRE_SP,
            AppCompatActivity.MODE_PRIVATE
        ).edit()
        editor.putString(Constantes.SP_GENERO, genero)
        editor.commit()
    }
}