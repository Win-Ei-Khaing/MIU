package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intt = intent // Similar to  Intent intent = getIntent()
        val output = intt.getStringExtra("message")
       // val output1 = intt.getIntExtra("message",90)
        rmsg.text = output
    }
}
