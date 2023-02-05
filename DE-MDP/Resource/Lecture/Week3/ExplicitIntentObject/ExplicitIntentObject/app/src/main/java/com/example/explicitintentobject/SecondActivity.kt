package com.example.explicitintentobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
class SecondActivity : AppCompatActivity() {
    lateinit var result: UserAccount
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
       /* var tv1 = findViewById<TextView>(R.id.fn)
        var tv2 = findViewById<TextView>(R.id.ln)
        var tv3 = findViewById<TextView>(R.id.mid)
        val intent = intent*/
        val temp = intent.getSerializableExtra("user") // return Serializable Object
        result = temp as UserAccount // Casting Serializable type of temp to UserAccount --> UserAccount result = (UserAccount)temp
        fn.text = result.firstName
        ln.text = result.lastName
        mid.text = result.emailId
        Toast.makeText(this,result.toString(),Toast.LENGTH_LONG).show()
    }
}