package com.example.pmfinal

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView

 class ListAdapter(lista :  MutableList<RM>, context:Context) :RecyclerView.Adapter<ListAdapter.ViewHolder>(){
     private var lista = mutableListOf<RM>()
     private lateinit var mInflater : LayoutInflater
     private lateinit var context : Context

     fun ListAdapter(lista :  MutableList<RM>, context:Context){
         this.mInflater = LayoutInflater.from(context )
         this.context = context
         this.lista = lista
     }
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         var view =mInflater.inflate(R.layout.list_listas_1rm,null)
         return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bindData(lista.get(position))
     }

     override fun getItemCount(): Int {
         return lista.size
     }
     class ViewHolder(view : View) : RecyclerView.ViewHolder(view){


         val tvrm : TextView
         val tvfecha : TextView
         val tvmax : TextView
         init{
             tvrm  =  view.findViewById(R.id.peso)
             tvfecha = view.findViewById(R.id.fecha)
             tvmax = view.findViewById(R.id.Maximo)
         }

         fun bindData(rm:RM) {
             tvrm.setText(rm.repM)
             tvfecha.setText(rm.fecha)
             tvmax.setText(rm.max)
         }
     }



 }