package com.example.ch11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.example.ch11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, TwoActivity::class.java)
            startActivity(intent)
        }

    }
    // 17 page
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            // ctrl + i 단축키
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("henry", "on query submit $query")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("henry", "$newText")
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main,menu)
//        return super.onCreateOptionsMenu(menu)
//    }


//        옵션 선택  p15
//        override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId) {
//            R.id.menu1 -> {
//                Log.d("henry", "menu1 click")
//                true
//            }
//
//            R.id.menu2 -> {
//                Log.d("henry", "menu2 click")
//                true
//            }
//            R.id.menu3 -> {
//                Log.d("henry", "menu3 click")
//                true
//            }
//            else -> {
//                super.onOptionsItemSelected(item)
//            }
//        }
//    }

//    p11
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//         val menuItem1: MenuItem? = menu?.add(0,0,0,"menu1")
//         val menuItem2: MenuItem? = menu?.add(0,1,0,"menu2")
//        val menuItem3: MenuItem? = menu?.add(Menu.NONE,1,Menu.NONE,"menu3")
//        return super.onCreateOptionsMenu(menu)
//    }
//     사용자가 메뉴를 선택했을 때 콜백
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId) {
//            0 -> {
//                Log.d("henry", "menu1 click")
//                true
//            }
//
//            1 -> {
//                Log.d("henry", "menu2 click")
//                true
//            }
//
//            else -> {
//                super.onOptionsItemSelected(item)
//            }
//        }
//    }
}