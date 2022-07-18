package com.example.pmfinal.settings

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.pmfinal.Constantes
import com.example.pmfinal.R

class AjustesFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settingsajustes, container, false)
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        crearCanalNotificacion()

        val switch = view.findViewById<Switch>(R.id.switchNoti)
        switch?.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Switch1:ON"
            else "Switch1:OFF"
            val notif = crearNotificacion("OLIMPO",
                "Notificaciones activadas!")
            NotificationManagerCompat.from(requireContext()).notify(
                1,
                notif
            )
            //Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            if(switch.isChecked){
                Toast.makeText(requireContext(), "PRENDIDO", Toast.LENGTH_SHORT).show()
                val notif = crearNotificacion("OLIMPO",
                    "Notificaciones activadas!")
                NotificationManagerCompat.from(requireContext()).notify(
                    1,
                    notif
                )
            }
        }
    }

    private fun crearCanalNotificacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = Constantes.NotificationData.NOTIFICATION_CHANNEL_NAME
            val descriptionText = Constantes.NotificationData.NOTIFICATION_CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(
                Constantes.NotificationData.NOTIFICATION_CHANNEL_ID,
                name,
                importance
            ).apply {
                description = descriptionText
            }

            val notificationManager = requireActivity().getSystemService(
                Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun crearNotificacion(title : String, content : String) : Notification {

        val notification = NotificationCompat.Builder(
            requireContext(),
            Constantes.NotificationData.NOTIFICATION_CHANNEL_ID
        ).setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(androidx.core.R.drawable.notification_icon_background)
            .setPriority(NotificationCompat.PRIORITY_HIGH).build()

        return notification
    }

}