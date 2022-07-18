package com.example.pmfinal.NavFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.Constantes.listaRm.Companion.lista_RM
import com.example.pmfinal.ListAdapter
import com.example.pmfinal.R
import com.example.pmfinal.models.RM
import progresoFragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round

class CalculatorFragment : Fragment() {
    private lateinit var rVrm : RecyclerView
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
        rVrm =view.findViewById(R.id.rVrm)
        var lista = mutableListOf<RM>()
        var etReps =view.findViewById<EditText>(R.id.etReps)
        var etPeso =view.findViewById<EditText>(R.id.etPeso)
        val butCal = view.findViewById<Button>(R.id.butCalcular)

        val butGuardar = view.findViewById<Button>(R.id.butGuardar)


        if(lista_RM.size!=0) cargarListaRM(lista_RM)

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
            val txtReps=etReps!!.getText()
            val txtPeso=etPeso!!.getText()
            val tvRMest = view.findViewById<TextView>(R.id.tvRMest)
            if (txtReps.length>0 && txtPeso.length>0){




                var peso = round(txtPeso!!.toString().toInt() / ( 1.0278 - 0.0278 * txtReps!!.toString().toInt() ))
                tvRMest.setText(peso.toString())

                val sdf = SimpleDateFormat("dd/M/yyyy")
                val currentDate = sdf.format(Date())

                val RPMAX =peso.toString();
                val fechaMAX = currentDate ;
                val actualrm = RM(RPMAX,fechaMAX,"");

                lista_RM.add(actualrm)


                cargarListaRM(lista_RM)

            }
            else{
                tvRMest.setText("Ingrese algun dato")
            }
        }




    }
    private fun cargarListaRM(lista: List<RM>) {
        Log.d("se hizo clic", lista[0].toString())
        val adapter = ListAdapter(lista) {
            Log.i("Fragment", "Se hizo click en el " + it.repM);
        }

        rVrm.adapter = adapter
    }




}