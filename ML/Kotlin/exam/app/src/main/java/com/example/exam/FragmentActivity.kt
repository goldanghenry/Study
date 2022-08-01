package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        val fragment1: FragmentOne = FragmentOne()
        //  fragment에 데이터를 넣어주는 방법
        // 번들을 만들어 프라그먼트에 끼워넣어야 한다.
        val bundle : Bundle = Bundle()
        bundle.putString("hello", "hello")
        // 프라그먼트에 넣어주기
        fragment1.arguments = bundle // 번들 할당 시키기


       button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // fragment 붙이는 방법 replace/add
            // 동적으로 작동시키기 위해서는 fragment 매니저가 필요하나
            val fragmentManager:FragmentManager = supportFragmentManager

            // Transaction
            // 작업 단위 ->> 시작과 끝이 있다.
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, fragment1)
            fragmentTransaction.commit() // commit은 끝

            // 끝을 내는 방법
            // commit       -> (temsys)시간 될 때 해 -> 안정적
            // commitnow    -> (temsys)지금 당장해
            }
        button2.setOnClickListener {
            //fragment remove/detach 하는 방법
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragment1)
            fragmentTransaction.commit()
            }
        }

        override fun onStart() {
            super.onStart()
            Log.d("life_cycle", "onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.d("life_cycle", "onResume")
        }

        override fun onPause() {
            super.onPause()
            Log.d("life_cycle", "onPause")
        }

        override fun onStop() {
            super.onStop()
            Log.d("life_cycle", "onStop")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d("life_cycle", "onDestroy")
        }
    }