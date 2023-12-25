package com.example.ch13

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ch13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startActivityBtn1.setOnClickListener {
            val intent : Intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        binding.startActivityBtn2.setOnClickListener {
            val intent : Intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("data1", "hello")
            intent.putExtra("data2", 10)
            startActivity(intent)
        }

        binding.startActivityBtn3.setOnClickListener {
            val intent: Intent = Intent(this,DetailActivity::class.java)
            startActivityForResult(intent,10)
        }

        binding.clearBtn.setOnClickListener {
            binding.mainTextView.text = ""
        }

        binding.goToDetailBtn.setOnClickListener {
            val intent:Intent = Intent(this, DetailActivity::class.java)
            requestLauncher.launch(intent)
        }

    }

    val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        val resultData = it.data?.getStringExtra("result")
        binding.mainTextView.text = "result : $resultData"
    }




// 기존 콜백 함수
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        //page 8
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
//            val result = data?.getStringExtra("resultData")
//            binding.mainTextView.text="resultData: $result"
//        }
//
//    }
}