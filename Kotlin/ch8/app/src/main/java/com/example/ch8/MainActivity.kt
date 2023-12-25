package com.example.ch8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import androidx.activity.OnBackPressedCallback
import com.example.ch8.databinding.ActivityMainBinding
/* 뷰 리스너 방법 3
class MyEventHandler : CompoundButton.OnCheckedChangeListener{
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.d("kkang","체크박스 클릭")
    }
}
*/
/* 뷰 리스너 방법 2 : 인터페이스 구현  */
class MainActivity : AppCompatActivity(),CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.CB.setOnCheckedChangeListener(this)
//        //binding.CB.setOnCheckedChangeListener(MyEventHandler())
//
//        binding.button.setOnClickListener {
//            Log.d("kkang","click event")
//        }
//        binding.button.setOnLongClickListener {
//            Log.d("kkang","long click event")
//            true
//        }
        // 위의 코드와 동일
        binding.button.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {
                Log.d("kkang","long click event")
                return true
            }
        })


    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.d("kkang","체크박스 클릭")
    }
}
/* 뷰 리스너 방법 1 : 익명 클래스 구현해 객체를 전달
//        binding.CB.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
//            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//                Log.d("kkang",
//                    "check")
//            }
//
//        })
*/

/*      뒤로가기 1
//        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                TODO("Not yet implemented")
//            }
//        })

//      뒤로가기 2
//    override fun onBackPressed() {
//        super.onBackPressed()
//        super.onBackPressed()
//        Log.d("kkang","Back Button을 눌렀네요")
//    }
////    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
//        Log.d("kkang", "onKeyUp")
//        return super.onKeyUp(keyCode, event)
//    }
*/

/*     터치 이벤트
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when(event?.action) {
//            MotionEvent.ACTION_DOWN -> {
//                Log.d("kkang", "Touch down event")
//            }
//            MotionEvent.ACTION_UP -> {
//                Log.d("kkang", "Touch up event")
//            }
//        }
//
//        return super.onTouchEvent(event)
//    }


//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when (event?.action) {
//            MotionEvent.ACTION_DOWN -> {
//                Log.d(
//                    "kkang",
//                    "Touch down event \n" +
//                            "x:${event.x}, rawX:${event.y}\n" +
//                            "rawX:${event.rawX}, rawY:${event.rawY}\n"
//                )
//            }
//        }
//        return super.onTouchEvent(event)
//    }
*/

/*
// 물리버튼 1
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        when(keyCode) {
//            KeyEvent.KEYCODE_BACK -> Log.d("kkang", "뒤로가기 Button을 눌렀네요")
//            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("kkang", "VOLUME_UP을 눌렀네요")
//            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("kkang", "VOLUME_DOWN을 눌렀네요")
//        }
//        return super.onKeyDown(keyCode, event)
//    }
*/