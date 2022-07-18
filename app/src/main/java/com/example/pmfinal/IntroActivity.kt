package com.example.pmfinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmfinal.IntroFragments.Slide1Fragment

class IntroActivity : AppCompatActivity() {
    private val fragmentslide1 = Slide1Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_PMFinal);
        super.onCreate(savedInstanceState)

        if (verificarLoginSP()) {//2da o + vez

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else {//primera vez
            setContentView(R.layout.activity_intro)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fcvIntro, fragmentslide1)
            ft.commit()
        }
    }

    fun verificarLoginSP() : Boolean{
        // Leer del SP si existe un USERNAME
        val sp = getSharedPreferences(Constantes.NOMBRE_SP, Context.MODE_PRIVATE)
        val username = sp.getString(Constantes.SP_USERNAME, "")!!

        return username != ""
    }
}