package com.example.pmfinal.NavFragments.FitnessFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.IntroFragments.Slide2Fragment
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoBodyPartsAdapter
import com.example.pmfinal.models.GestorEjercicios

class FitnessFragment : Fragment() {
    private var bodyPartsfragment = BodyPartsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fitness, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newRutina = view.findViewById<LinearLayout>(R.id.butNewRutina)

        newRutina.setOnClickListener {
            val ft = requireActivity().supportFragmentManager?.beginTransaction()
            ft.replace(R.id.fragment_container_main, bodyPartsfragment)
            ft.addToBackStack(null)
            ft.commit()
        }


    }
}