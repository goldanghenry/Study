package com.example.test13_app5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.test13_app5.databinding.ActivityMainBinding

import kotlinx.coroutines.*

import java.nio.channels.Channel
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ch13 slide p.49 - 시간이 오래 걸리는 작업 예
        //  ANR 오류가 발생하는 코드

//        binding.btnClick.setOnClickListener {
//            var sum = 0L
//            var time = measureTimeMillis {
//                for ( i in 1..2_000_000_000) {
//                    sum += i
//                }
//            }
//            Log.d("kkang", "time : $time")
//            binding.resultView.text = "sum : $sum"
//        }

        // ch13 slide p.50 - 스레드-핸들러 구조로 작성한 코드
        // 교재 코드 - arg1에 대입 시 오버플로우 발생
        /*
        binding.btnClick.setOnClickListener {
            val handler = object: Handler() {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    binding.resultView.text = "sum: ${msg.arg1}"
                }
            }

            thread {
                var sum = 0L
                var time = measureTimeMillis {
                    for ( i in 1..2_000_000_000) {
                        sum += i
                    }
                    val message = Message()
                    message.arg1 = sum.toInt()   // arg1은 int(32비트), sum은 Long (64비트) => arg1에서 오버플로우 발생
                    handler.sendMessage(message)
                }
                Log.d("kkang", "time : $time")
            }
        }
        */

        // ch13 slide p.50 - 스레드-핸들러 구조로 작성한 코드 => 수정
        // Bundle 객체에 sum을 담아 전송함으로 arg1의 오버플로우 해결
        /*
        binding.btnClick.setOnClickListener {
            val handler = object: Handler() {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    binding.resultView.text = "sum: ${msg.data.getCharSequence("sum")}"
                }
            }

            thread {
                var sum = 0L
                var time = measureTimeMillis {
                    for ( i in 1..2_000_000_000) {
                        sum += i
                    }
                    val message = Message()

                    // 번들 객체에 결과를 String으로 담아 보냄
                    val data = Bundle()
                    data.putCharSequence("sum", sum.toString())
                    message.data = data

                    handler.sendMessage(message)
                }
                Log.d("kkang", "time : $time")
            }
        }
        */

        // ch13 slide p.52 - 코루틴으로 작성한 소스

        binding.btnClick.setOnClickListener {
            val channel = Channel<Long>()
            val backgroundScope = CoroutineScope(Dispatchers.Default + Job())
            backgroundScope.launch {
                var sum = 0L
                var time = measureTimeMillis {
                    for ( i in 1..2_000_000_000) {
                        sum += i
                    }
                }
                Log.d("kkang", "time : $time")
                channel.send(sum)
            }

            val mainScope = GlobalScope.launch(Dispatchers.Main) {
                channel.consumeEach {
                    binding.resultView.text = "sum: $it"
                }
            }
        }

    }// onCreate
}// MainActivity