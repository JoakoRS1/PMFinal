package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoSeriesAdapter
import com.example.pmfinal.models.RM
import com.example.pmfinal.models.serie

class SeriesFragment:Fragment() {
    private lateinit var rvSeries : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_series_ejercicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var numSeries= 1
        rvSeries= view.findViewById(R.id.rvSeriesReps)
        val nombreEjercicio= view.findViewById<TextView>(R.id.tvEjNombre)
        val butAgregarSerie= view.findViewById<Button>(R.id.butNewSerie)
        val butAgregarHorario= view.findViewById<Button>(R.id.butNewHorario)

        nombreEjercicio.text=arguments?.getString("NOMBRE_EJERCICIO")

        var series=mutableListOf<serie>()
        series.add(serie(numSeries,0,0))

        cargarSeries(series)

        butAgregarSerie.setOnClickListener{
            numSeries++
            series.add(serie(numSeries,0,0))
            cargarSeries(series)
        }

        butAgregarHorario.setOnClickListener{
            //Ir a FragmentHorario
            val ft = requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_main, HorarioFragment())
            ft.addToBackStack(null)
            ft.commit()

        }

    }
    fun cargarSeries(series: List<serie>){
        val adapter= ListadoSeriesAdapter(series)
        rvSeries.adapter=adapter
    }
}