package com.example.pmfinal.adapters

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.ListAdapter
import com.example.pmfinal.R
import com.example.pmfinal.models.serie

class ListadoSeriesAdapter (private val mListaSeries:List<serie>):
RecyclerView.Adapter<ListadoSeriesAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val n_serie:TextView
        val kg:EditText
        val reps :EditText

        init{
            n_serie=view.findViewById(R.id.tvNumRep)
            kg=view.findViewById(R.id.etKG)
            reps=view.findViewById(R.id.etReps)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_series_nuevo_ej, parent, false)

        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rm= mListaSeries[position]
        holder.n_serie.text=rm.serie.toString()
        holder.kg.setText(rm.kg.toString())
        holder.reps.setText(rm.reps.toString())
    }

    override fun getItemCount(): Int {
        return mListaSeries.size
    }


}