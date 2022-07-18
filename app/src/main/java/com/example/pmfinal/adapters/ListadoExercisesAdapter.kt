package com.example.pmfinal.adapters

import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pmfinal.R
import com.example.pmfinal.models.beans.Ejercicio
import kotlinx.coroutines.NonDisposableHandle.parent

class ListadoExercisesAdapter (private val mListaExercises : List<Ejercicio>,
                               private val mOnItemClickListener : (NombreEjercicio : Ejercicio) -> Unit) :
    RecyclerView.Adapter<ListadoExercisesAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tviExerciseName : TextView
        val imgEjercicio: ImageView

        init{
            tviExerciseName= view.findViewById(R.id.tviExerciseNameItem)
            imgEjercicio = view.findViewById(R.id.imgEjercicio)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListadoExercisesAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise,parent,false)
        val viewHolder= ViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviExerciseName.text= mListaExercises[position].name

        val urlgif = mListaExercises[position].gifUrl.toUri()

        Glide.with(holder.itemView).asBitmap().load(urlgif).into(holder.imgEjercicio)

        holder.itemView.setOnClickListener{
            mOnItemClickListener(mListaExercises[position])
        }
    }

    override fun getItemCount(): Int {
        return mListaExercises.size
    }
}