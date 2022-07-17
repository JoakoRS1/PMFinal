package com.example.pmfinal.NavFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.pmfinal.R
import com.example.pmfinal.settings.AjustesFragment
import com.example.pmfinal.settings.perfilFragment

class SettingsFragment : Fragment() {
    private val perfil= AjustesFragment()
    private val ajustes= perfilFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var butPerfil = view.findViewById<LinearLayout>(R.id.butPerfil)
        var butAjustes = view.findViewById<LinearLayout>(R.id.butAjustes)
        butPerfil?.setOnClickListener{
            val ft = requireActivity().supportFragmentManager?.beginTransaction()
            ft!!.replace(R.id.fragment_container_main, perfil)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }
        butAjustes?.setOnClickListener{
            val ft = requireActivity().supportFragmentManager?.beginTransaction()
            ft!!.replace(R.id.fragment_container_main, ajustes)
            ft!!.addToBackStack(null)
            ft!!.commit()
        }
    }
}