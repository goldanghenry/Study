package com.example.test13_app3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.test13_app3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
        }

        binding.textView.text = count.toString()
        binding.countBtn.setOnClickListener {
            count++
            binding.textView.text = count.toString()
            Log.d("henry", "$count")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("henry","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("henry","onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
        Log.d("henry","$count onSaveInstanceState")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        Log.d("henry","$count onRestoreInstanceState")
    }



    override fun onPause(){
        super.onPause()
        Log.d("henry","onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.d("henry","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("henry","onStop")
    }
}