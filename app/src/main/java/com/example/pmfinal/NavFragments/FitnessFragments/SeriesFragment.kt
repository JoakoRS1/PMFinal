package com.example.pmfinal.NavFragments.FitnessFragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.get
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.Constantes
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoSeriesAdapter
import com.example.pmfinal.models.Rutinas.RutinaCreate
import com.example.pmfinal.models.serie
import org.json.JSONObject

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
        var numSeries= 0
        rvSeries= view.findViewById(R.id.rvSeriesReps)
        val nombreEjercicio= view.findViewById<TextView>(R.id.tvEjNombre)
        val butAgregarSerie= view.findViewById<Button>(R.id.butNewSerie)
        val butSave= view.findViewById<Button>(R.id.butSaveSeries)

        val etkg=view.findViewById<EditText>(R.id.etKG)
        val etReps=view.findViewById<EditText>(R.id.etReps)
        val butAgregarHorario= view.findViewById<Button>(R.id.butNewHorario)


        val ej_nom=arguments?.getString("NOMBRE_EJERCICIO")
        nombreEjercicio.text=ej_nom

        var series=mutableListOf<serie>()


        butAgregarSerie.setOnClickListener{
            numSeries++
            series.add(serie(numSeries,etkg.text.toString().toInt(),etReps.text.toString().toInt()))
            cargarSeries(series)
        }
        butSave.setOnClickListener{
            var ultimateListadoSeries= series
            crearOactualizarRutina(requireContext(), ultimateListadoSeries,ej_nom!!)

            val fragFitness= FitnessFragment()

            val ft = requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_main, fragFitness)
            ft.commit()


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
    fun crearOactualizarRutina(context:Context, series: List<serie>,ejercicio:String){
        val ejercicioJson= JSONObject()
        ejercicioJson.put("nombre",ejercicio)
        ejercicioJson.put("serie",series)

        val sp = context.getSharedPreferences(
            Constantes.NOMBRE_SP,
            Context.MODE_PRIVATE
        )
        val en_edicion = sp.getString(Constantes.RUT_EDITED, "")!!

        if (en_edicion==""){
            RutinaCreate().crearRutina(context,ejercicioJson)
        }
        else{
            RutinaCreate().actualizarRutina(context,ejercicioJson)
        }


    }
}