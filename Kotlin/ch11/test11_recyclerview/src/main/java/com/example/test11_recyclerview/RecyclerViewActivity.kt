package com.example.test11_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.test11_recyclerview.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("Title")

        val datas = mutableListOf<String>()
        for ( i in 1..10) {
            datas.add("item $i")
        }
//        datas.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
//        datas.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
//        datas.add("cccccccccccccccccccccccccc")
//        datas.add("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
//        datas.add("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
        binding.addBtn.setOnClickListener {
            datas.add("new iem")
            //(binding.recyclerView.adapter as MyAdapter).notifyDataSetChanged()
            (binding.recyclerView.adapter as MyAdapter).notifyItemInserted(datas.size)
        }

        binding.removeBtn.setOnClickListener {
            if(datas.size > 0)
                datas.removeLast()
            (binding.recyclerView.adapter as MyAdapter).notifyItemRemoved(datas.size)
        }
        // p.33 ~ 35
        /*
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        */


        // p.36
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        binding.recyclerView.layoutManager = layoutManager

        // p.37
//        val layoutManager = GridLayoutManager(this,2)
//        val layoutManager = GridLayoutManager(this,3, GridLayoutManager.HORIZONTAL, false)
//        val layoutManager = GridLayoutManager(this,3, GridLayoutManager.HORIZONTAL, true)

        // p.39
//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(datas)
        binding.recyclerView.addItemDecoration(MyDecoration(this))










    }
}