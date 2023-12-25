package com.example.test13_app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test13_app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)
        title = "Test13_App1"

    }
}