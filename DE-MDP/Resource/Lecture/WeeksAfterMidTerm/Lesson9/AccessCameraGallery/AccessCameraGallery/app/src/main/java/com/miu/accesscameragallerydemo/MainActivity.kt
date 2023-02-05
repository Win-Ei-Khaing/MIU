package com.miu.accesscameragallerydemo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var startforResultCamera : ActivityResultLauncher<Intent>
    lateinit var startforResultGalley : ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get captured image from the Camera Intent to set on the ImageView UI
        startforResultCamera  = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ it ->
            if(it.resultCode == Activity.RESULT_OK && it.data!=null){
                val extras = it.data!!.extras
                val imageBitmap = extras?.get("data") as Bitmap // Similar java code is  Bitmap imageBitmap = (Bitmap) extras.get("data");
                iv.setImageBitmap(imageBitmap)
            }
            else{
                Toast.makeText(this,"Fail to retrieve", Toast.LENGTH_LONG).show()
            }
        }
        // Get the image from the Gallery using GetConent() from ActivityResultContract
        startforResultGalley =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it!=null)
               iv.setImageURI(it.data?.data)
            else
                Toast.makeText(this,"Fail to retrieve", Toast.LENGTH_LONG).show()
        }
        // Start taking picture by clicking Camera button from your activity
        camera.setOnClickListener {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePictureIntent.resolveActivity(packageManager) != null) {
                    // Call launch by passing
                    startforResultCamera.launch(takePictureIntent)
                }
            }

        // Start Pick picture by clicking Camera button from Gallery app
        gallery.setOnClickListener {
            val i = Intent()
            // Activity Action for the intent : Pick an item from the data, returning what was selected.
            i.action = Intent.ACTION_PICK
            i.type = "image/*"
            startforResultGalley.launch(i)
        }
    }
}