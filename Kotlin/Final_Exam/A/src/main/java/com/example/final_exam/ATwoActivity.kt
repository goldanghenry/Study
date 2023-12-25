package com.example.final_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.final_exam.databinding.ActivityAoneBinding
import com.example.final_exam.databinding.ActivityAtwoBinding

class ATwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAtwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("A")

        binding.goToBOneActivity.setOnClickListener {
            val intent : Intent = Intent("ACTION_EDIT")
            startActivity(intent)
        }
    }
}