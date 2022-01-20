package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)


        val ment = resources.getString(R.string.hello)
        Log.d("ment","ment: "+ment)

        val ment2 = getString(R.string.hello)
        Log.d("ment","ment: "+ment2 )

        val color = getColor(R.color.textview_color)
        Log.d("color", "color:" + color)

        button.setBackgroundColor(getColor(R.color.textview_color))

    }
}