package com.example.pmfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.R

class ListadoBodyPartsAdapter (private val mListaBodyPArts : List<String>,
    private val mOnItemClickListener : (BodyPart : String) -> Unit) :
    RecyclerView.Adapter<ListadoBodyPartsAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPartName : TextView

        init {
            tviPartName = view.findViewById(R.id.tviPartName)
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
        holder.tviPartName.text = mListaBodyPArts[position]
        holder.itemView.setOnClickListener {
            mOnItemClickListener(mListaBodyPArts[position])
        }
    }

    override fun getItemCount(): Int {
        return mListaBodyPArts.size
    }

}