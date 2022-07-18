package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoExercisesAdapter
import com.example.pmfinal.models.GestorEjercicios
import com.example.pmfinal.settings.perfilFragment

class EjerciciosFragment:Fragment() {

    private val nuevo= NuevoEjerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercises, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bodyPart= arguments?.getString("NOMBRE_BODY_PART")
        val listaEjercicios= GestorEjercicios().MostrarListadoEjercicios(requireContext(),bodyPart!!)

        val recyclerView= view.findViewById<RecyclerView>(R.id.rvExercises)
        val fragDetalles= DetallesFragment()

        val adapter = ListadoExercisesAdapter(listaEjercicios){
            val bundle= Bundle()
            bundle.putString("NOMBRE_EJERCICIO", it.name)
            bundle.putString("EQUIPMENT", it.equipment)
            bundle.putString("GIF_URL", it.gifUrl)
            bundle.putString("TARGET", it.target)

            Log.d("valselec:",it.name)
            Log.d("valselec:",it.equipment)
            Log.d("valselec:",it.gifUrl)
            Log.d("valselec:",it.target)

            fragDetalles.arguments= bundle

            //Ir a FragmentDetalles
            val ft = requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_main, fragDetalles)
            ft.addToBackStack(null)
            ft.commit()
        }

        val layoutNuevo = view.findViewById<LinearLayout>(R.id.layoutNuevo)

        layoutNuevo.setOnClickListener {
            val ft = requireActivity().supportFragmentManager?.beginTransaction()
            ft!!.replace(R.id.fragment_container_main, nuevo)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }


        recyclerView.adapter=adapter
    }
}