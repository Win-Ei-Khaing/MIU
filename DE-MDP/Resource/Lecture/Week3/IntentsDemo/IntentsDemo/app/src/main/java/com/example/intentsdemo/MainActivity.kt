package com.example.intentsdemo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSendMessageExplicit(view: View) {
        var input = smsg.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message", input);
        startActivity(intent);
    }
    fun onSendMessageImplicit(view: View) {
        var input = smsg.text.toString()
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, input)
        startActivity(intent)
    }
   /*fun whatsapp(view: View) {
        // To open Third Party app Whatsapp directly
        val i = packageManager.getLaunchIntentForPackage("com.whatsapp")
        if(i!=null)
            startActivity(i)
        else
            Toast.makeText(applicationContext,"WhatsApp not installed",Toast.LENGTH_LONG).show()
    }*/
    fun whatsapp(view: View) {
        val whatsAppAppId = "com.whatsapp"
        try {
            intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val text = smsg.text.toString()
//the following line will throw the NameNotFoundException if WhatsApp is not installed in the phone
            intent.`package`= whatsAppAppId
            intent.putExtra(Intent.EXTRA_TEXT, text);
            //startActivity(intent)
            startActivity(Intent.createChooser(intent, "Finish the action with:"));

        } catch (e: PackageManager.NameNotFoundException) {

        }

    }
    fun dial(view: View) {
        val i = Intent()
        i.action = Intent.ACTION_DIAL
        val et2 = tel.text.toString()
        i.data = Uri.parse("tel:$et2") //tel: data representation of telephony number
        startActivity(i)
    }
}
