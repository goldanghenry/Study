package com.example.test11_viewpager_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2
import com.example.test11_viewpager_fragment.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("Title")

        binding.viewpager.adapter = MyFragmentPagerAdapter(this)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_VERTICAL // 스와이프 방향
    }
}