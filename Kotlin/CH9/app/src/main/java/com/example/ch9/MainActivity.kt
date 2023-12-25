package com.example.ch9

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowMetrics
import com.example.ch9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            val binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            // Build.VERSION_CODES.R -> api 30 level
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
                binding.textview.text = "width: ${windowMetrics.bounds.width()},"+
                                        "height : ${windowMetrics.bounds.height()}"
            } else {
                val display = windowManager.defaultDisplay
                val displayMetrics = DisplayMetrics()
                display?.getRealMetrics(displayMetrics)
                binding.textview.text = "width: ${displayMetrics.widthPixels}," +
                                        " height : ${displayMetrics.widthPixels}"
        }




    }
}