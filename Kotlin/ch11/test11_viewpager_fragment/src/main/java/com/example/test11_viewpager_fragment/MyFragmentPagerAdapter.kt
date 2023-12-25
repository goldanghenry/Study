package com.example.test11_viewpager_fragment

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFragmentPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){
    val fragments:List<Fragment>
    init {
//        fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
        fragments = listOf(
            OneFragment.newInstance("one", "frag"),
            TwoFragment.newInstance("two", "frag"),
            ThreeFragment.newInstance("three", "frag"),
        )
        Log.d("henry", "fragment size : ${fragments.size}")
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}
