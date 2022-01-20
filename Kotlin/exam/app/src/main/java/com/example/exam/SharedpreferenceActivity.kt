package com.example.exam

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sharedpreference.*

class SharedpreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpreference)

        //Sharedpreference 에 저장하는 방법

        // Mode
        // 1) MODE_PRIVATE : 생성한 application 에서만 사용 가능
        // 2) MODE_WORLD_READABLE : 다른 app 에서 사용 가능 -> ReadOnly
        // 3) MODE_WORLD_WRITEABLE : 다른 app 에서 사용 가능 -> Can Write
        // 4) MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // 5) MODE_APPEND : 기존 preference 에 신규로 추가
        // 앱끼리 상호작용해야할 때 2,3) 사용하는데 사용하는 경우가 없다.
//        val editor : SharedPreferences.Editor = sharedpreference.edit()
//        editor.putString("hello", "안녕하세요")
//        editor.commit()

        // sp1 -> sharedpreference -> Key-vlaue -> ( "hello", "안녕하세요")
        // sp2 -> sharedpreference -> Key-vlaue -> ( "hello", "안녕하세요22")
        // -> 이렇게 한다고 해서 sp1의 안녕하세요 값이 바뀌지는 않는다

        // 값을 불러오는 방법
        // 디폴트 밸류

        save_btn.setOnClickListener {
            val sharedpreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedpreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goobye", "안녕히가세요")
            editor.commit()
        }

        load_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음")
            val value2 = sharedPreference.getString("goobye", "데이터 없음")
            Log.d("key-value", "Value1: "+ value1)
            Log.d("key-value", "Value2: "+ value2)
        }
        delete_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello") // 특정 키 밸류
            editor.commit() // 사용후 항상 커밋
        }
        delete_all_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear() // 전부 지우기
            editor.commit()
        }
    }
}