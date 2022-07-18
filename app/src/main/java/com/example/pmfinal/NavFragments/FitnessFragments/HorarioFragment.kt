package com.example.pmfinal.NavFragments.FitnessFragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pmfinal.R
import com.example.pmfinal.models.beans.BodyPart
import com.example.pmfinal.models.serie
import com.example.pmfinal.room.AppDatabase
import com.example.pmfinal.room.dao.EjerciciosRoomDAO
import com.example.pmfinal.room.models.EjerciciosRoom

class HorarioFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_horario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val GuardarHorario= view.findViewById<Button>(R.id.GuardarHorario)

        val butDom= view.findViewById<Button>(R.id.Dom)
        val butLun= view.findViewById<Button>(R.id.Lun)
        val butMar= view.findViewById<Button>(R.id.Mar)
        val butMie= view.findViewById<Button>(R.id.Mier)
        val butJue= view.findViewById<Button>(R.id.Jue)
        val butVie= view.findViewById<Button>(R.id.Vie)
        val butSab= view.findViewById<Button>(R.id.Sab)

        var dias = mutableListOf<String>()

        cambiarcolor(butDom, dias)
        cambiarcolor(butLun, dias)
        cambiarcolor(butMar, dias)
        cambiarcolor(butMie, dias)
        cambiarcolor(butJue, dias)
        cambiarcolor(butVie, dias)
        cambiarcolor(butSab, dias)


        GuardarHorario.setOnClickListener{

        }

    }

    private fun cambiarcolor(boton: Button, listaDias: MutableList<String>){
        boton.setOnClickListener {
            boton.isEnabled = false;
            boton.setBackgroundColor(Color.BLUE)
            var dia = boton.text as String;
            Log.i("dia", dia)
            listaDias.add(dia)
        }

    }

}