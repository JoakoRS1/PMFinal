package com.example.pmfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R
import com.example.pmfinal.models.beans.Ejercicio

class ListadoExercisesAdapter (private val mListaExercises : List<Ejercicio>,
                               private val mOnItemClickListener : (NombreEjercicio : Ejercicio) -> Unit) :
    RecyclerView.Adapter<ListadoExercisesAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tviExerciseName : TextView

        init{
            tviExerciseName= view.findViewById(R.id.tviExerciseNameItem)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListadoExercisesAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_exercise,parent,false)
        val viewHolder= ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviExerciseName.text= mListaExercises[position].name
        holder.itemView.setOnClickListener{
            mOnItemClickListener(mListaExercises[position])
        }
    }

    override fun getItemCount(): Int {
        return mListaExercises.size
    }
}