package com.example.exam.Android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.exam.R
import kotlinx.android.synthetic.main.activity_library_acticity.*

class LibraryActicity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_acticity)

        Glide.with(this@LibraryActicity)
            .load("https://image.laftel.net/items/thumbs/large/f3203d2d-13e7-43fc-afb0-a43a9a5fe56b.jpg")
            .into(glide)
    }
}