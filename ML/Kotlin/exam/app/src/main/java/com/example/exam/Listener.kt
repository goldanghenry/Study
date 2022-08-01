package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_listner.*


class Listener : AppCompatActivity() {

    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listner)

        //val textView : TextView = findViewById(R.id.hello)
        // 1. 람다방식
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        }

        // 2. 익명함수 방식
        hello.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click","Click!")
            }
        })

        // 3. 이름이 필요한 경우(click)
        val click = object: View.OnClickListener {
            override fun onClick(v:View?){
                Log.d("click","Click!")
                hello.setText("안녕하세요")
                image.setImageResource(R.drawable.user)
                number += 10
                Log.d("number","" + number)
            }
        }
        hello.setOnClickListener(click)




    }
}