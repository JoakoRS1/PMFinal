package com.example.pmfinal

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pmfinal.NavFragments.CalculatorFragment
import com.example.pmfinal.NavFragments.FitnessFragments.FitnessFragment
import com.example.pmfinal.NavFragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: AppCompatActivity() {
    private val calculator= CalculatorFragment()
    private val fitness= FitnessFragment()
    private val settings= SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(calculator)


                val peso = txtReps!!.toString().toInt() *(1+(txtPeso!!.toString().toInt()/30))
                tvRMest.setText(peso.toString())
            }
            else{
                tvRMest.setText("Ingrese algun dato")
            }
        }

        val bottomNav= findViewById<BottomNavigationView>(R.id.bottomNav)
        var etReps =findViewById<EditText>(R.id.etReps)
        var etPeso =findViewById<EditText>(R.id.etPeso)
        val butCal = findViewById<Button>(R.id.butCalcular)


        butCal?.setOnClickListener {

            val txtReps=etReps!!.getText()
            val txtPeso=etPeso!!.getText()
            val tvRMest = findViewById<TextView>(R.id.tvRMest)
            if (txtPeso.length>0 && tvRMest.length()>0){

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.calc -> replaceFragment(calculator)
                R.id.settings->replaceFragment(settings)
                R.id.fit -> replaceFragment(fitness)
            }
            true
        }
    }

    private fun replaceFragment(fragment:Fragment){
        if (fragment!=null){
            val ft= supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_container_main,fragment)
            ft.addToBackStack(null)
            ft.commit()
        }
    }
}