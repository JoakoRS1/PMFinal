package com.example.pmfinal.models.beans

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Ejercicio(
    val bodyPart : String,
    val equipment : String,
    val gifUrl : String,
    val name:String,
    val target:String,
    val id: String

)