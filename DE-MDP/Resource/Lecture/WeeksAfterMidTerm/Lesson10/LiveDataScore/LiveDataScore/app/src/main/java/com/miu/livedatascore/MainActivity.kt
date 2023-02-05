package com.miu.livedatascore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize the ViewModel to retrieve the data from the ViewModel
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        // countA Livedata observer implementation
        mainViewModel.countA.observe(this) {
            tvScorePlayerA.text = it.toString()
        }
        mainViewModel.countB.observe(this) {
            tvScorePlayerB.text = it.toString()
        }
        btnPlayerA.setOnClickListener{
            mainViewModel!!.updateCountA()
       }
        // Click Listener to increment the playerB Score by 1 for each click and updated on the ScoreTextView
        btnPlayerB.setOnClickListener{
            mainViewModel!!.updateCountB()
       }
    }
}