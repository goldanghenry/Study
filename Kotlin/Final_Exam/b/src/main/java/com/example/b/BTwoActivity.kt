package com.example.b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b.databinding.ActivityBtwoBinding

class BTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBtwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("B")

        binding.goToATwoActivity.setOnClickListener {
            val intent : Intent = Intent("ACTION_EDIT2")
            startActivity(intent)
        }
    }
}