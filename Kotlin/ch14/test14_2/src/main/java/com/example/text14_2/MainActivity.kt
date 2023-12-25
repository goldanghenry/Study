package com.example.text14_2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.util.Log

class MainActivity : AppCompatActivity() {
    lateinit var receiver1 : BroadcastReceiver
    lateinit var receiver2 : BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        f2()
        //f3()
        f4()

    }
    // 동적 스크린 온 오프
    fun f2() {
        receiver1 = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when(intent?.action) {
                    Intent.ACTION_SCREEN_ON -> Log.d("henry", "screen on")
                    Intent.ACTION_SCREEN_OFF-> Log.d("henry", "screen off")
                }
            }
        }
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON).apply {
            addAction(Intent.ACTION_SCREEN_OFF)
        }
        registerReceiver(receiver1,filter)

        // Power On/Off isInteractive로 화면 상태 알 수 있음 => ok
        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        if (pm.isInteractive) {
            // screen on - 에뮬레이터 전원을 켠 상태에서 앱을 빌드하기
            Log.d("henry", "POWER_SERVICE - power On")
        } else {
            // screen off - 에뮬레이터 전원을 끈 상태에서 앱을 빌드하기
            Log.d("henry", "POWER_SERVICE - power OFF")
        }
    }

    fun f3() {
        // 10p 배터리 상태
        receiver2 = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when(intent?.action) {
                    Intent.ACTION_BATTERY_OKAY -> Log.d("henry", "ACTION_BATTERY_OKAY")
                    Intent.ACTION_BATTERY_LOW -> Log.d("henry", "ACTION_BATTERY_LOW")
                    Intent.ACTION_BATTERY_CHANGED -> Log.d("henry", "ACTION_BATTERY_CHANGED")
                    Intent.ACTION_POWER_CONNECTED -> Log.d("henry", "ACTION_POWER_CONNECTED")
                    // TOast.makeText(this@MainActiivty, "ACTION_POWER_CONNECTED", Toast.LENGTH_LONG).show()
                    Intent.ACTION_POWER_DISCONNECTED -> Log.d("henry", "ACTION_POWER_DISCONNECTED")
                }
            }
        }
        val filter2 = IntentFilter(Intent.ACTION_BATTERY_OKAY).apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_BATTERY_CHANGED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(receiver2,filter2)
    }

    // p11. 시스템 인텐트 없이 배터리 상태 파악하기
    fun f4() {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = registerReceiver(null, intentFilter)

        val status = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        if(status == BatteryManager.BATTERY_STATUS_CHARGING) {
            val chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            when(chargePlug) {
                BatteryManager.BATTERY_PLUGGED_USB -> Log.d("henry", "usb charge") // 저속 충전 상태
                BatteryManager.BATTERY_PLUGGED_AC -> Log.d("henry", "usb charge") // 고속 충전 상태
            }
        } else {
            Log.d("henry", "not charging")
        }

    }
}