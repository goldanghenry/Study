package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_mytube_detail.*

class MytubeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)

        val url = intent.getStringExtra("video_url")
        val mediaController = MediaController(this@MytubeDetailActivity)
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()
        mediaController.show()

    }
}