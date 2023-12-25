package com.example.q2

import OneFragment
import ThreeFragment
import TwoFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.q2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val items = arrayOf<String>("사자","호랑이","판다")
    val choices = booleanArrayOf(true, true, true)

    class MyFragmentPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {
        val fragments: List<Fragment>
        init {
            fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
        }
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("2014097056 우성현")

        val tablayout: TabLayout = binding.tabs

        val tab1:TabLayout.Tab = tablayout.newTab()
        tablayout.addTab(tab1)

        val tab2:TabLayout.Tab = tablayout.newTab()
        tablayout.addTab(tab2)

        val tab3:TabLayout.Tab = tablayout.newTab()
        tablayout.addTab(tab3)

        val viewPager = binding.viewpager
        viewPager.adapter = MyFragmentPagerAdapter(this)

        val bundle = Bundle()
        bundle.putStringArray("items", items)
        bundle.putBooleanArray("choices", choices)



        TabLayoutMediator(tablayout, viewPager) {tab, position ->
            tab.text = "Tab${(position+1)}"
        }.attach()

    }


}