package com.example.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exam.R

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, // view를 그려주는 역할
        container: ViewGroup?,   // 부모뷰(달라 붙을 곳)
        savedInstanceState: Bundle?
    ): View? {  // return type : view
        Log.d("life_cycle", "F onCreateView")
        // fragment가 interface(xml의 fargment tag)를 처음으로 draw할 때 호출된다.
        return inflater.inflate(R.layout.fragment_two,container, false)
    }
}