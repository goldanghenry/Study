package com.example.ch14

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ch14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.explicitBtn.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java)
            sendBroadcast(intent)
        }

        // 지금은 안됨
//        binding.explicitBtn.setOnClickListener {
//            val intent = Intent("ACTION_RECEIVER")
//            sendBroadcast(intent)
//        }

        // 동적 리시버 생성
        val receiver = object :BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d("henry","onReceive ... 2")
            }
        }

        val filter = IntentFilter("ACTION_RECEIVER")
        registerReceiver(receiver, filter)

        binding.inplicitBtn.setOnClickListener {
            val intent = Intent("ACTION_RECEIVER")
            sendBroadcast(intent)
        }

        unregisterReceiver(receiver)

    }
}