package com.example.pmfinal.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.IntroFragments.Slide3Fragment
import com.example.pmfinal.NavFragments.FitnessFragments.EjerciciosFragment
import com.example.pmfinal.R
import org.json.JSONObject

class ListadoRutinasAdapter (private val mListaExercises : List<JSONObject>) :
    RecyclerView.Adapter<ListadoRutinasAdapter.ViewHolder>(){

    private val EjerciciosFragment = EjerciciosFragment()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tviExerciseName : TextView
        val tvPreviewEj : TextView
        val butIniciar: Button
        init{
            tviExerciseName= view.findViewById(R.id.tvRutinaCreada)
            tvPreviewEj = view.findViewById(R.id.tvPreviewEj)
            butIniciar= view.findViewById(R.id.butIniciarRutina)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.rutinas_creadas,parent,false)
        val viewHolder= ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ejr= mListaExercises[position].getJSONArray("ejercicios")
        var l_ejercicios= ""

        for (i in 0 until ejr.length()){
            var ejercicioguardado= ejr[i] as JSONObject
            l_ejercicios+=ejercicioguardado.get("nombre")
            l_ejercicios+="."
        }

        holder.tviExerciseName.text= "Rutina "+(position+1).toString()
        holder.tvPreviewEj.text= "Ejercicios: "+l_ejercicios.toString()





    }

    override fun getItemCount(): Int {
        return mListaExercises.size
    }
}