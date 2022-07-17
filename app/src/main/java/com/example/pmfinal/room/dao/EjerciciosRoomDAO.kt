package com.example.pmfinal.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pmfinal.room.models.BodyPartsRoom
import com.example.pmfinal.room.models.EjerciciosRoom
@Dao
interface EjerciciosRoomDAO {
    @Query("SELECT * FROM EjerciciosRoom")
    fun getAll() : List<EjerciciosRoom>

    @Query("SELECT bodyPart FROM EjerciciosRoom GROUP BY bodyPart")
    fun getAllBodyParts() : List<String>

    @Query("SELECT * FROM EjerciciosRoom WHERE bodyPart=:bodyPart")
    fun ExercisesByBodyParts(bodyPart:String) : List<EjerciciosRoom>

    @Insert
    fun insert(ejercicio : EjerciciosRoom)

}