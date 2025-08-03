package com.example.ch10_notification

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.RemoteInput
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val replyTxt = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_text_reply")
        Log.d("kkang", "replyText:$replyTxt")
        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE)
            as NotificationManager
        manager.cancel(11)
    }
}