package com.example.exam

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener {
       //     val intent = Intent(this@Intent1, Intent2::class.java)
      //      intent.putExtra("number1", 1)
       //     intent.putExtra("number2",2)
       //     startActivity(intent)

//            val intent2 = Intent(this@Intent1, Intent2::class.java)
//            intent2.apply{
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//                startActivityForResult(intent2,200) // 요청하는 인텐트, 구분하기 위한 이름
//            // 전달만 할때는 : startActivity(intent) / 리턴을 받을 때는 forresult
//            }
            // 암시적 인텐트 : 버튼을 누르면 특정 인터넷 브라우저
            // ACTION_VIEW : 다음에 적는 부분을 보여주라, 의도 전달
            // 인터넷 주소는 "" 해서 적으면 x, Uri.parse("")해서 적어야 한다.
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
        }
    }
    // resultCode는 intent2의 setResult의 인자부분
    // requestCode
    // data는 resultintent
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==200) { // 내가 보낸게 맞는지 확인
            Log.d("number", ""+requestCode) //Log를 찍어 확인하기
            Log.d("number", ""+resultCode)
            val result = data?.getIntExtra("result",0)
            Log.d("number",""+result)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}