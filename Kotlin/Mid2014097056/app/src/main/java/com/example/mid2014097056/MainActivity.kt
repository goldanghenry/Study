package com.example.mid2014097056

import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import com.example.mid2014097056.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var checkNum = 0    /// 5, 6, 7, 8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                checkNum = p1
                Log.d("henry", "$checkNum")
            }
        })

        binding.showBtn.setOnClickListener {

            val eventHandler = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    if (which == DialogInterface.BUTTON_POSITIVE) {
                        Log.d("henry", "positive button click")
                    } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                        Log.d("henry", "negative button click")
                    }
                }
            }

            if (checkNum == 1) {
                var image = ImageView(this).also{
                    it.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.cat))
                }
                AlertDialog.Builder(this).run {
                    setTitle("cat")
                    setView(image)
                    setNegativeButton("Close", eventHandler)
                    show()
                }
            }
            else if (checkNum == 2) {
                var image = ImageView(this).also {
                    it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.dog))
                }
                AlertDialog.Builder(this).run {
                    setTitle("dog")
                    setView(image)
                    setNegativeButton("Close", eventHandler)
                    show()
                }
            }
            else if (checkNum == 3) {
                var image = ImageView(this).also {
                    it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.horse))
                }
                AlertDialog.Builder(this).run {
                    setTitle("horse")
                    setView(image)
                    setNegativeButton("Close", eventHandler)
                    show()
                }
            }
            else if (checkNum == 4) {
                var image = ImageView(this).also {
                    it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rabbit))
                }
                AlertDialog.Builder(this).run {
                    setTitle("rabbit")
                    setView(image)
                    setNegativeButton("Close", eventHandler)
                    show()
                }
            }





        }









    }
}