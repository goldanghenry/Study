package com.example.test13_app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test13_app1.databinding.ActivityMainBinding
import com.example.test13_app1.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.twoToolbar)
        title = "Test13_App1"
    }
}