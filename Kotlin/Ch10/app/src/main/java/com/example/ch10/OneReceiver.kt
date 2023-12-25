package com.example.ch10

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class OneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d("henry", "receive")
    }
}