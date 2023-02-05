package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onSendMessage(view:View){
        var input = smsg.text.toString()
        var tst = Toast.makeText(applicationContext,"Top Toast", Toast.LENGTH_LONG);
        // Can display the Toast in the Top, Default location is in the Bottom.
       // tst.setGravity(Gravity.TOP, 0, 0)
        tst.show()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message",input) // Here message is a key to retrieve the input text in the second activity
        startActivity(intent)
    }
}
