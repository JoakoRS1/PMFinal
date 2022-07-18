package com.example.pmfinal.models.Rutinas

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pmfinal.Constantes
import com.example.pmfinal.models.beans.Ejercicio
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.NullPointerException

class RutinaCreate{
    fun crearRutina(context: Context, ejercicio:JSONObject) {
        val rutinasCreadas= verificarRutinaActual(context)+1

        val ejercicios= mutableListOf<JSONObject>()
        ejercicios.add(ejercicio)

        val newRutina= JSONObject()

        newRutina.put("horario","L-M-V")
        newRutina.put("ejercicios",ejercicios)


        //Crea la rutina
        context.openFileOutput("Rutina"+rutinasCreadas.toString()+".json", Context.MODE_PRIVATE)
            .use {
            it.write(newRutina.toString().toByteArray())
        }

        //Actualiza la cantidad de rutinas
        val editor = context.getSharedPreferences(Constantes.NOMBRE_SP,AppCompatActivity.MODE_PRIVATE
        ).edit()
        editor.putString(Constantes.RUTINAS, rutinasCreadas.toString())
        editor.commit()

        Log.i("rutinasLectura", "Rutina"+rutinasCreadas.toString()+".json")
        context.openFileInput("Rutina"+rutinasCreadas.toString()+".json").use {
            Log.i("rutinasLectura", it.bufferedReader().readLine())
        }
    }


    fun verificarRutinaActual(context: Context) : Int{
        // Leer del SP qué rutina es
        val sp = context.getSharedPreferences(
            Constantes.NOMBRE_SP,
            Context.MODE_PRIVATE
        )
        val numRutina = sp.getString(Constantes.RUTINAS, "")!!
        if (numRutina==""){
            return 0
        }
        return numRutina.toInt()
    }

    fun ObtenerRutinas(context: Context):List<JSONObject>{
        var arrjson= mutableListOf<JSONObject>()
        try{
            var rutinasCreadas= (verificarRutinaActual(context)).toInt()
            Log.d("rutinascreadas",rutinasCreadas.toString())

            var j=0
            while (j<rutinasCreadas) {
                context.openFileInput("Rutina" + rutinasCreadas.toString() + ".json").use {
                    var json =it.bufferedReader().readText()
                    var jsonobj= JSONObject(json)
                    arrjson.add(jsonobj)
                }
                j++
            }
            return arrjson
        }
        catch (e:NullPointerException){
            return arrjson
        }
    }

    fun actualizarRutina(context: Context, ejercicio:JSONObject){

    }
}