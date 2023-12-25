package com.example.b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.b.databinding.ActivityBoneBinding

class BOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("B")

        binding.goToBTwoActivity.setOnClickListener {
            val intent : Intent = Intent(this, BTwoActivity::class.java)
            startActivity(intent)
        }
    }
}