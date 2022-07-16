package com.example.pmfinal

import android.content.Context
import android.content.SharedPreferences

class IntroductionManger(context: Context) {

    private var pref: SharedPreferences = context.getSharedPreferences(
        R.string.preference_file_key.toString(),
        Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = pref.edit()
    fun setFirst(isFirst: Boolean) {
        editor.putBoolean("check", isFirst)
        editor.apply()
    }

    fun check(): Boolean {
        return pref.getBoolean("check", false)
    }

}