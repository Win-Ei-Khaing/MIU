package com.miu.viewmodeldemo

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
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java   )
        // Initially load zero to score field
        tvScorePlayerA.text = mainViewModel!!.countA.toString()
        tvScorePlayerB.text = mainViewModel!!.countB.toString()
        // Click Listener to increment the playerA Score by 1 for each click
        // and updated on the ScoreTextView
        btnPlayerA.setOnClickListener{
            mainViewModel!!.updateCountA()
            tvScorePlayerA.text = mainViewModel!!.countA.toString()
        }
        // Click Listener to increment the playerB Score by 1 for each click and updated on the ScoreTextView
        btnPlayerB.setOnClickListener{
            mainViewModel!!.updateCountB()
            tvScorePlayerB.text = mainViewModel!!.countB.toString()
        }
    }
}