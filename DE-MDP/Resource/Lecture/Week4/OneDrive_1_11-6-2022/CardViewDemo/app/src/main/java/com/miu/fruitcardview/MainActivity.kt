package com.miu.fruitcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var imageges = intArrayOf(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.cherries,
        R.drawable.dates,
        R.drawable.grapes,
        R.drawable.mango
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       var s1 = resources.getStringArray(R.array.fruits);
      var  s2 = resources.getStringArray(R.array.desc);
       var s3 = resources.getStringArray(R.array.detail);
        rv.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this,s1 , s2 ,imageges,s3 )
        // Set adapter to your RecyclerView
        rv.adapter = adapter
    }
}