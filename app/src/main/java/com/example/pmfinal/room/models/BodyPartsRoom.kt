package com.example.pmfinal.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BodyPartsRoom (

    @ColumnInfo(name = "bodyPart")
    val bodyPart : String,
    @ColumnInfo(name = "gifUrl")
    val gifUrl : String,

    @PrimaryKey( autoGenerate = true)
    val id : String
)