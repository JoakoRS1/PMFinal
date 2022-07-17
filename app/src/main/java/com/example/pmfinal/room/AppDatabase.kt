package com.example.pmfinal.room

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pmfinal.room.dao.EjerciciosRoomDAO
import com.example.pmfinal.room.models.EjerciciosRoom

@Database(entities = arrayOf(EjerciciosRoom::class), version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun getEjerciciosRoomDAO(): EjerciciosRoomDAO

    companion object {
        private var mInstance : AppDatabase? = null
        @JvmStatic
        fun getInstance(context : Context) : AppDatabase {
            if (mInstance == null) {
                mInstance = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java
                ).allowMainThreadQueries().build()
            }
            return mInstance!!
        }
    }
}