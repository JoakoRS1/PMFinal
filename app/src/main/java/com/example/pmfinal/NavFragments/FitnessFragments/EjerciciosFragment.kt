package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R
import com.example.pmfinal.models.GestorEjercicios

class EjerciciosFragment:Fragment() {
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


    }
}