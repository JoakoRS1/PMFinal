package com.example.pmfinal.NavFragments.FitnessFragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pmfinal.Constantes
import com.example.pmfinal.R
import com.example.pmfinal.adapters.ListadoBodyPartsAdapter
import com.example.pmfinal.models.GestorEjercicios
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BodyPartsFragment : Fragment() {
    private lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_body_parts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler= view.findViewById(R.id.rvBodyParts)
        val sp = requireActivity().getSharedPreferences(
            Constantes.NOMBRE_SP, Context.MODE_PRIVATE)
        val estaSincronizado = sp.getString(Constantes.SP_ESTA_SINCRONIZADO, "")!!


            GlobalScope.launch(Dispatchers.Main) {
                var lista = withContext(Dispatchers.IO){
                    GestorEjercicios().obtenerListaBodyParts(requireContext().applicationContext)

                }
                if (lista.size==0){
                    Log.d("entro","no sinc")
                    withContext(Dispatchers.IO){
                        GestorEjercicios().obtenerListaEjerciciosCorutina(requireContext(),requireActivity())
                        lista =GestorEjercicios().obtenerListaBodyParts(requireContext().applicationContext)
                    }
                }

                Log.d("entro","obtuvo datos")
                cargarBodyParts(lista)
            }
    }
    fun cargarBodyParts(lista:List<String>){
        val adapter = ListadoBodyPartsAdapter(lista){
            Log.i("ListadoBodyPartsAdapter", "Se hizo click en " + it);

            val bundle= Bundle()
            bundle.putString("NOMBRE_BODY_PART", it)
            val fragEjercicios= EjerciciosFragment()
            fragEjercicios.arguments= bundle

            //Ir a FragmentEjercicios
            val ft = requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_main, fragEjercicios)
            ft.addToBackStack(null)
            ft.commit()
        }
        recycler.adapter = adapter


    }
}