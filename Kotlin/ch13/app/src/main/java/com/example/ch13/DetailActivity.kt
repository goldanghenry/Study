package com.example.ch13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch13.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.finishBtn.setOnClickListener {
            finish()
        }

        binding.getExtraBtn.setOnClickListener {
            val data1 = intent.getStringExtra("data1")
            val data2 = intent.getIntExtra("data2",0)
            binding.detailTextView.text = "data1: ${data1}, data2: ${data2}"
        }

        binding.returnBtn.setOnClickListener {
            //page 7
            intent.putExtra("resultData","world")
            setResult(RESULT_OK,intent)
            finish()
        }

        binding.goToMainBtn.setOnClickListener {
            intent.putExtra("result", "world")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
