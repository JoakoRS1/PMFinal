package com.example.pmfinal.models.Rutinas

import android.content.Context
import android.util.Log
import com.example.pmfinal.Constantes
import com.example.pmfinal.models.beans.Ejercicio
import org.json.JSONException
import org.json.JSONObject
import java.lang.NullPointerException

class RutinaCreate{
    fun crearRutina(context: Context, ejercicios:List<JSONObject>) {

        val rutinasCreadas= verificarRutinaActual(context)
        val newRutina= JSONObject()


        newRutina.put("horario","L-M-V")
        newRutina.put("ejercicios",ejercicios)


        //Se van a sobrescribir las rutinas
        context.openFileOutput("Rutina"+(rutinasCreadas+1).toString()+".json", Context.MODE_PRIVATE).use {
            it.write(newRutina.toString().toByteArray())
        }

        context.openFileInput("Rutinas.json").use {
            Log.i("TAG", it.bufferedReader().readLine())
        }
    }


    fun verificarRutinaActual(context: Context) : Int{
        // Leer del SP qué rutina es
        val sp = context.getSharedPreferences(
            Constantes.RUTINAS,
            Context.MODE_PRIVATE
        )
        val numRutina = sp.getString(Constantes.SP_USERNAME, "")!!
        if (numRutina==""){
            return 0
        }
        return numRutina.toInt()
    }

    fun ObtenerRutinas(context: Context){
        try{
            //por si no hay
        }
        catch (e:NullPointerException){

        }
    }
}