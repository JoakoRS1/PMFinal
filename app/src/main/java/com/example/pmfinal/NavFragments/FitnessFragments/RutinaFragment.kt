package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pmfinal.R

class RutinaFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rutina, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvNombreEjercicioDetalle= view.findViewById<TextView>(R.id.tvEjercicio)
        //val ivDetailGif= view.findViewById<ImageView>(R.id.ivGIFDETALLE)

        val name= (arguments?.getString("NOMBRE_EJERCICIO"))
        //val gif= arguments?.getString("GIF_URL")

        tvNombreEjercicioDetalle.text=name

    }

}


