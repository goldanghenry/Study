package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread_acticity.*

class ThreadActicity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_acticity)

        val runnable : Runnable = object : Runnable {
            override fun run() { // 인플리먼트 메소드
                // 여기에 하고 싶은 일
                Log.d("thread_1", "thread is made")
            }
        }
        val thread: Thread = Thread(runnable)

        button.setOnClickListener {
            thread.start()
        }

        Thread(object :Runnable {
            override fun run() {
                Log.d("thread_1", "thread2 is made")
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(2000) //2초
            Log.d("thread_1", "thread3 is made")
            runOnUiThread{
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()

    }
}