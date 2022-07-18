package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.Constantes
import com.example.pmfinal.IntroFragments.Slide2Fragment
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoBodyPartsAdapter
import com.example.pmfinal.adapters.ListadoRutinasAdapter
import com.example.pmfinal.adapters.ListadoSeriesAdapter
import com.example.pmfinal.models.GestorEjercicios
import com.example.pmfinal.models.Rutinas.RutinaCreate

class FitnessFragment : Fragment() {
    private var bodyPartsfragment = BodyPartsFragment()
    private lateinit var rvRutinas : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fitness, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newRutina = view.findViewById<LinearLayout>(R.id.butNewRutina)
        rvRutinas=view.findViewById(R.id.rvRutinas)
        var rutinas= RutinaCreate().ObtenerRutinas(requireContext())

        Log.d("cantidad de rutinas", rutinas.size.toString())


        val adapter= ListadoRutinasAdapter(rutinas)
        rvRutinas.adapter=adapter

        newRutina.setOnClickListener {
            val editor = requireActivity().getSharedPreferences(
                Constantes.NOMBRE_SP,
                AppCompatActivity.MODE_PRIVATE
            ).edit()
            editor.putString(Constantes.RUT_EDITED, "") //LA RUTINA SE DEBE CREAR
            editor.commit()

            val ft = requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_main, bodyPartsfragment)
            ft.addToBackStack(null)
            ft.commit()
        }




    }
}