package com.example.pmfinal.models

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.system.Os.open
import android.util.Log
import com.example.pmfinal.Constantes
import com.example.pmfinal.models.beans.BodyPart
import com.example.pmfinal.models.beans.Ejercicio
import com.example.pmfinal.room.AppDatabase
import com.example.pmfinal.room.dao.EjerciciosRoomDAO
import com.example.pmfinal.room.models.EjerciciosRoom
import javax.xml.parsers.DocumentBuilderFactory


class GestorEjercicios {
    fun obtenerListaEjerciciosCorutina(context: Context, activity: Activity) {
        val br= context.assets.open("fitnessexercises.csv").bufferedReader()
        br.readLine()
        var cont=0;
        var data: String? = null
        var tito=true

        while(tito){
            data = br.readLine()
            if (data==null) {
                tito=false
            }
            else {
                guardarListaEjerciciosRoom(context,data)
                //Log.d("LLEGAMOS ACA", data!!)
                cont++
            }
        }
        Log.d("datoCorutina", cont.toString())
        //guardar
    }

    fun guardarListaEjerciciosRoom( context: Context, ejercicio : String) {
        val db = AppDatabase.getInstance(context)
        val daoEjercicios : EjerciciosRoomDAO = db.getEjerciciosRoomDAO()


        var result= ejercicio.split(",")

        daoEjercicios.insert(
            EjerciciosRoom(
                result[0].capitalize(),
                result[1].capitalize(),
                result[2],
                result[4].capitalize(),
                result[5].capitalize(),
                result[3].capitalize()
            )
        )
        Log.d("seguardo", result[0])
    }
    fun obtenerListaBodyParts (context : Context) : List<BodyPart> {
        val daoBodyParts : EjerciciosRoomDAO = AppDatabase.getInstance(
            context).getEjerciciosRoomDAO()

        val listaRoom = daoBodyParts.getAllBodyParts()
        val info = listaRoom.map {
            BodyPart(it.bodyPart, it.gifUrl)
        }

        Log.d("tamaolista", listaRoom.size.toString())

        return info
    }
    fun MostrarListadoEjercicios(context: Context, filtro: String): List<Ejercicio>{
        val daoBodyParts : EjerciciosRoomDAO = AppDatabase.getInstance(context).getEjerciciosRoomDAO()

        val listaEjercicios = daoBodyParts.ExercisesByBodyParts(filtro)
        val res = listaEjercicios.map {
            Ejercicio(it.bodyPart, it.equipment, it.gifUrl, it.name,it.target, it.id)
        }
        return res
    }
}