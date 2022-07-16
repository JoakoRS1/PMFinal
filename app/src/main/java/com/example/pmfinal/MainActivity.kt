package com.example.pmfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pmfinal.NavFragments.CalculatorFragment
import com.example.pmfinal.NavFragments.FitnessFragment
import com.example.pmfinal.NavFragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity: AppCompatActivity() {
    private val calculator= CalculatorFragment()
    private val fitness= FitnessFragment()
    private val settings= SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(calculator)


        val bottomNav= findViewById<BottomNavigationView>(R.id.bottomNav)

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