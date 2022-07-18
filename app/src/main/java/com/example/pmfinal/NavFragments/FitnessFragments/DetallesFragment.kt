package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.util.Log
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
import com.example.pmfinal.settings.perfilFragment

class DetallesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalles_ejercicios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragRutina= RutinaFragment()

        val tvNombreEjercicioDetalle= view.findViewById<TextView>(R.id.tvNombreEjercicioDetalle)
        val ivDetailGif= view.findViewById<ImageView>(R.id.ivGIFDETALLE)
        val tvDescripcionEjercicio= view.findViewById<TextView>(R.id.tvDescripcionEjercicio)
        val butElegir= view.findViewById<Button>(R.id.butElegir)

        val name= (arguments?.getString("NOMBRE_EJERCICIO"))
        val equipment= arguments?.getString("EQUIPMENT")
        val gif= arguments?.getString("GIF_URL")
        val target= arguments?.getString("TARGET")

        val urlgif= gif?.toUri()
        val descripcion= "Needed Equipment: "+equipment!! +".\n\nTarget area: "+target!!

        tvDescripcionEjercicio.text=descripcion
        tvNombreEjercicioDetalle.text=name

        Glide.with(requireContext()).load(urlgif).into(ivDetailGif)


        butElegir.setOnClickListener {
            val ft = requireActivity().supportFragmentManager?.beginTransaction()
            ft!!.replace(R.id.fragment_container_main, fragRutina)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }

    }
}