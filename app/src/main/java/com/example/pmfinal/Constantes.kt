package com.example.pmfinal

import com.example.pmfinal.models.RM

class Constantes {
    companion object {
        val NOMBRE_SP = "SP_GYMBRO"
        val SP_USERNAME = "USERNAME"
        val SP_GENERO = "GENERO"
        val SP_EDAD= "EDAD"
        val SP_PESO= "PESO"
        val SP_ALTURA= "ALTURA"
        val SP_IMC= "IMC"
        val SP_ESTA_SINCRONIZADO= "ESTA_SINCRONIZADO"
        val RUTINAS="NUM_RUTINAS"
        val RUT_EDITED= "RUTINA_SIENDO_EDITADA"

    }

    class NotificationData {
        companion object {
            val NOTIFICATION_CHANNEL_ID = "1"
            val NOTIFICATION_CHANNEL_NAME = "LOGIN"
            val NOTIFICATION_CHANNEL_DESCRIPTION = "Notification channel"
        }
    }
    class listaRm{
        companion object{
            val lista_RM = mutableListOf<RM>()
        }
    }


}