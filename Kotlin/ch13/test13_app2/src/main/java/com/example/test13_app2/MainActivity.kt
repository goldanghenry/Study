package com.example.test13_app2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.test13_app2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)
        title = "Test13_App2"

//         버전 1
//        binding.goToApp1TwoActivity.setOnClickListener {
//            val intent = Intent()
//            intent.action = "ACTION_EDIT"
//            intent.data = Uri.parse("http://www.google.com")
//            startActivity(intent)
//        }

        // 버전 2
        binding.goToApp1TwoActivity.setOnClickListener {
            val intent = Intent("Action_EDIT", Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        binding.test1Btn.setOnClickListener {
            val intent = Intent("ACTION_HELLO")
            try {
                startActivity(intent)
            } catch (e:Exception) {
                Toast.makeText(this, "no app...", Toast.LENGTH_SHORT).show()
            }
        }
        binding.test2Btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749, 127.4194"))
            startActivity(intent)
        }
        binding.test3Btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.7749, 127.4194"))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
        binding.test4Btn.setOnClickListener {
            val packageInfo = packageManager.getPackageInfo("com.example.test13_app1", 0)
            val versionName = packageInfo.versionName

            Log.d("henry", "version name: $versionName")
            Toast.makeText(this, "version name: $versionName",Toast.LENGTH_SHORT ).show()
        }

    }
}