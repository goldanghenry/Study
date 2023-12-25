package com.example.q2

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = TextView(this).apply {
            text = "2014097056 우성현"
        }
        val image = ImageView(this).also {
            it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cat))
        }
        val catBtn = Button(this).apply {
            text = "CAT"
        }
        val dogBtn = Button(this).apply {
            text = "DOG"
        }
        val horseBtn = Button(this).apply {
            text = "HORSE"
        }
        val rabbitBtn = Button(this).apply {
            text = "RABBIT"
        }
        val layout2 = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            addView(catBtn, WRAP_CONTENT, WRAP_CONTENT)
            addView(dogBtn, WRAP_CONTENT, WRAP_CONTENT)
            addView(horseBtn, WRAP_CONTENT, WRAP_CONTENT)
            addView(rabbitBtn, WRAP_CONTENT, WRAP_CONTENT)
        }
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(name, WRAP_CONTENT, WRAP_CONTENT)
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(layout2)
        }
        setContentView(layout)

        catBtn.setOnClickListener {
            val btnImg = ImageView(this).also {
                it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.cat))
            }
            layout.apply{
                removeAllViews()
                addView(name, WRAP_CONTENT, WRAP_CONTENT)
                addView(btnImg, WRAP_CONTENT, WRAP_CONTENT)
                addView(layout2)
            }
        }

        dogBtn.setOnClickListener {
            val btnImg = ImageView(this).also {
                it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dog))
            }
            layout.apply{
                removeAllViews()
                addView(name, WRAP_CONTENT, WRAP_CONTENT)
                addView(btnImg, WRAP_CONTENT, WRAP_CONTENT)
                addView(layout2)
            }
        }

        horseBtn.setOnClickListener {
            val btnImg = ImageView(this).also {
                it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.horse))
            }
            layout.apply{
                removeAllViews()
                addView(name, WRAP_CONTENT, WRAP_CONTENT)
                addView(btnImg, WRAP_CONTENT, WRAP_CONTENT)
                addView(layout2)
            }
        }

        rabbitBtn.setOnClickListener {
            val btnImg = ImageView(this).also {
                it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rabbit))
            }
            layout.apply{
                removeAllViews()
                addView(name, WRAP_CONTENT, WRAP_CONTENT)
                addView(btnImg, WRAP_CONTENT, WRAP_CONTENT)
                addView(layout2)
            }
        }

    }
}

