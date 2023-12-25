package com.example.ch11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        title = "Title"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.d("henry","onSupportNavigateUp")
        onBackPressed()
        return super.onSupportNavigateUp()
    }
//    override fun onSupportNavigateUp(): Boolean {
//        Log.d("henry","onSupportNavigateUp")
//        onBackPressed()
//        return super.onSupportNavigateUp()
//    }
}