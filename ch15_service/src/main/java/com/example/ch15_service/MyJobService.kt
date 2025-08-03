package com.example.ch15_service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyJobService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.i("MyJobService", "Job started")

        // 알림 띄우기
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "oneId",
                "oneName",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "oneDesc"
            manager.createNotificationChannel(channel)
            NotificationCompat.Builder(this, "oneId")
        } else {
            NotificationCompat.Builder(this)
        }.run {
            setSmallIcon(android.R.drawable.ic_notification_overlay)
            setContentTitle("JobScheduler Title")
            setContentText("Content Message")
            setAutoCancel(true)
            manager.notify(1, build())
        }

        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.i("MyJobService", "Job stopped")
        return true
    }
}