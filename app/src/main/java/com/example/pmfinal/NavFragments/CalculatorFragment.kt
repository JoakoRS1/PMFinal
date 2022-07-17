package com.example.pmfinal.NavFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.pmfinal.R
import progresoFragment
import kotlin.math.round

class CalculatorFragment : Fragment() {
    private val progreso= progresoFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var etReps =view.findViewById<EditText>(R.id.etReps)
        var etPeso =view.findViewById<EditText>(R.id.etPeso)
        val butCal = view.findViewById<Button>(R.id.butCalcular)

        val butProgreso = view.findViewById<Button>(R.id.butProgreso)

        butProgreso.setOnClickListener {
            val ft = requireActivity().supportFragmentManager?.beginTransaction()
            ft!!.replace(R.id.fragment_container_main, progreso)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }


        butCal?.setOnClickListener {

            val txtReps=etReps!!.getText()
            val txtPeso=etPeso!!.getText()
            val tvRMest = view.findViewById<TextView>(R.id.tvRMest)
            if (txtReps.length>0 && txtPeso.length>0){

                var peso = round(txtPeso!!.toString().toInt() / ( 1.0278 - 0.0278 * txtReps!!.toString().toInt() ))
                tvRMest.setText(peso.toString())
            }
            else{
                tvRMest.setText("Ingrese algun dato")
            }
        }
    }

}