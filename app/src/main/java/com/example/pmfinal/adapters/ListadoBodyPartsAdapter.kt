package com.example.pmfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pmfinal.R
import com.example.pmfinal.models.beans.BodyPart

class ListadoBodyPartsAdapter (private val mListaBodyPArts : List<BodyPart>,
    private val mOnItemClickListener : (BodyPart : BodyPart) -> Unit) :
    RecyclerView.Adapter<ListadoBodyPartsAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPartName : TextView
        val tviPartImagen : ImageView

        init {
            tviPartName = view.findViewById(R.id.tviPartName)
            tviPartImagen = view.findViewById(R.id.imgPartName)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListadoBodyPartsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_body_part, parent, false)
        val viewHolder = ViewHolder(view)

        return viewHolder
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviPartName.text = mListaBodyPArts[position].bodyPart
        val urlgif = mListaBodyPArts[position].gifUrl.toUri()

        //Glide.with().load(urlgif).into(holder.tviPartImagen)

        holder.itemView.setOnClickListener {
            mOnItemClickListener(mListaBodyPArts[position])
        }
    }

    override fun getItemCount(): Int {
        return mListaBodyPArts.size
    }

}