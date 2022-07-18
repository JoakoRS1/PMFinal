package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoSeriesAdapter
import com.example.pmfinal.adapters.ListadoSeriesInicioAdapter
import com.example.pmfinal.models.serie
import org.json.JSONArray
import org.json.JSONObject

class EmpezarRutina: Fragment()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rutina_iniciada, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ejpresentado= view.findViewById<TextView>(R.id.tvRutinaIniciadaNom)
        val rvSeriesInicio= view.findViewById<RecyclerView>(R.id.rvSeriesInicio)

        val ejercicios= JSONArray(arguments?.getString("Ejercicios"))
        var num_ej= arguments?.getString("NUM_EJER")!!.toInt()

        val ejercicioPresente= ejercicios[num_ej] as JSONObject
        num_ej++

        ejpresentado.text=ejercicioPresente.getString("nombre")
/*
        val series = List<serie>(ejercicioPresente.getJSONArray("serie"))
        val adapter= ListadoSeriesInicioAdapter(series)
        rvSeriesInicio.adapter=adapter*/
    }

}