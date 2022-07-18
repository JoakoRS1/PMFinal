package com.example.pmfinal.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R
import com.example.pmfinal.models.beans.Ejercicio
import org.json.JSONObject

class ListadoRutinasAdapter (private val mListaExercises : List<JSONObject>) :
    RecyclerView.Adapter<ListadoRutinasAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tviExerciseName : TextView

        init{
            tviExerciseName= view.findViewById(R.id.tvRutinaCreada)
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
        holder.tviExerciseName.text= "Rutina "+(position+1).toString()


    }

    override fun getItemCount(): Int {
        return mListaExercises.size
    }
}