package com.example.exam

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment1.*

class FragmentOne:Fragment() {
//
//    interface OnDataPassListener {
//        fun onDataPass(data: String?)
//    }
//
//    lateinit var dataPassListener : OnDataPassListener
//
//
//    override fun onAttach(context: Context) {
//        Log.d("life_cycle", "F onAttach")
//        super.onAttach(context)
//        dataPassListener = context as OnDataPassListener
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "F onCreate")
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, // view를 그려주는 역할
//        container: ViewGroup?,   // 부모뷰(달라 붙을 곳)
//        savedInstanceState: Bundle?
//    ): View? {  // return type : view
//        Log.d("life_cycle", "F onCreateView")
//        // fragment가 interface(xml의 fargment tag)를 처음으로 draw할 때 호출된다.
//        return inflater.inflate(R.layout.fragment1,container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "F onViewCreated")
//        super.onViewCreated(view, savedInstanceState)
//
//        pass.setOnClickListener {
//            dataPassListener.onDataPass("Good Bye")
//        }
//
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        Log.d("life_cycle", "F onActivityCreated")
//
//        val data = arguments?.getString("hello")
//        if (data != null) {
//            Log.d("data", data)
//        }
//
//        super.onActivityCreated(savedInstanceState)
//    }
//
//    override fun onStart() {
//        Log.d("life_cycle", "F onStart")
//        super.onStart()
//    }
//
//    override fun onPause() {
//        Log.d("life_cycle", "F onPause")
//        super.onPause()
//    }
//
//    override fun onDestroyView() {
//        Log.d("life_cycle", "F onDestroyView")
//        super.onDestroyView()
//    }
//
//    override fun onDetach() {
//        Log.d("life_cycle", "F onDetach")
//        super.onDetach()
//    }
}