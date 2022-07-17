package com.example.pmfinal.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class EjerciciosRoom (

    @ColumnInfo(name = "bodyPart")
    val bodyPart : String,
    @ColumnInfo(name = "equipment")
    val equipment : String,
    @ColumnInfo(name = "gifUrl")
    val gifUrl : String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "target")
    val target: String,

    @PrimaryKey( autoGenerate = false)
    val id : String
)