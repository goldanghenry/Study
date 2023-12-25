//“2014097056 우성현”
//“본인은 이 소스파일을 다른 사람의 소스를 복사하지 않고 직접 작성하였습니다.”
package com.example.q3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.q3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBlue.setOnClickListener {
            Toast.makeText(this,
                "${it.width} x ${it.height}",
                Toast.LENGTH_SHORT).show()
        }
        binding.backYellow.setOnClickListener {
            Toast.makeText(this,
                "${it.width} x ${it.height}",
                Toast.LENGTH_SHORT).show()
        }
        binding.backBlack.setOnClickListener {
            Toast.makeText(this,
                "${it.width} x ${it.height}",
                Toast.LENGTH_SHORT).show()
        }
    }



}