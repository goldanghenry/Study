package com.example.test11_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test11_viewpager.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("Title")

        val datas = mutableListOf<String>()
        for ( i in 1..10)
            datas.add("item $i")

        binding.viewpager.adapter = MyPagerAdapter(datas)

    }
}