package com.example.pmfinal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.pmfinal.models.RM

class ListAdapter(private val mlistaRM : List<RM>, private val mOnClickListener: (rm : RM)->Unit)
     : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
     class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val tvRm: TextView
         val tvfecha: TextView
         val tvMax: TextView

         init {
             tvRm = view.findViewById(R.id.peso)
             tvfecha = view.findViewById(R.id.fecha)
             tvMax = view.findViewById(R.id.Maximo)
         }


     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
         val view = LayoutInflater.from(parent.context)
             .inflate(R.layout.list_listas_1rm, parent, false)

         val viewHolder =  ViewHolder(view)
         return viewHolder
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val rm = mlistaRM[position]
         holder.tvRm.text = rm.repM
         holder.tvfecha.text = rm.fecha
         holder.tvMax.text = rm.max
         holder.itemView.setOnClickListener {
             mOnClickListener(rm)
         }

     }

     override fun getItemCount(): Int {
         return mlistaRM.size
     }
 }