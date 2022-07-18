package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.pmfinal.R

class NuevoEjerFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nuevo_ejer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val eteNombre= view.findViewById<TextView>(R.id.eteNombre)
        val butElegir= view.findViewById<Button>(R.id.butElegir)

        butElegir.setOnClickListener{
            if (eteNombre.text.toString() != ""){
                val name = eteNombre.text.toString()

                val bundle= Bundle()
                bundle.putString("NOMBRE_EJERCICIO", name)

                val fragSeries= SeriesFragment()
                fragSeries.arguments= bundle

                //Ir a FragmentSeries
                val ft = requireActivity().supportFragmentManager.beginTransaction()
                ft.replace(R.id.fragment_container_main, fragSeries)
                ft.addToBackStack(null)
                ft.commit()
            }
            else{
                Toast.makeText(context, "Ingrese nombre de ejercicio", Toast.LENGTH_SHORT).show()
            }
        }
    }

}