package com.example.ch10

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat

class ReplyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val replyTxt = RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence("key_text_reply")
        Log.d("henry", "replyTxt $replyTxt")

        // 알림 취소
        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)

        /* 갱신
        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(context, "one-channel")
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setContentTitle("Content Title")
            .setContentText("Content Message")
        manager.notify(11, builder.build())
         */
    }
}