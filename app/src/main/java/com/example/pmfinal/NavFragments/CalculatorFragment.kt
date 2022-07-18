package com.example.pmfinal.NavFragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.ListAdapter
import com.example.pmfinal.R
import com.example.pmfinal.RM
import progresoFragment
import kotlin.math.round
import kotlin.Array

class CalculatorFragment : Fragment() {
    private lateinit var rms : RecyclerView
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
        rms =view.findViewById(R.id.rVrm)
        var lista = mutableListOf<RM>()
        var etReps =view.findViewById<EditText>(R.id.etReps)
        var etPeso =view.findViewById<EditText>(R.id.etPeso)
        val butCal = view.findViewById<Button>(R.id.butCalcular)

        val butGuardar = view.findViewById<Button>(R.id.butGuardar)

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
        butGuardar.setOnClickListener{
            val RPMAX ="123";
            val fechaMAX = "123";
            val actualrm = RM(RPMAX,fechaMAX,"");
            lista.add(actualrm)
            init()
        }



    }
    private fun init(){
        var elementos2 : List<RM>
        var elementos = mutableListOf<RM>()
        val RPMAX ="123";
        val fechaMAX = "123";
        val actualrm = RM(RPMAX,fechaMAX,"");
        elementos.add(actualrm)

        val adapter = ListAdapter(elementos,requireContext())

        var rView = view?.findViewById<RecyclerView>(R.id.rVrm)
        rView?.setHasFixedSize(true)
        rView?.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        rView?.adapter = adapter

    }



}