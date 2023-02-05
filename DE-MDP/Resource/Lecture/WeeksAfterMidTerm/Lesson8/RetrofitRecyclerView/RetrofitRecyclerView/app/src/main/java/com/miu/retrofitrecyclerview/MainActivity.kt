package com.miu.retrofitrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.miu.retrofituser.network.APIInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val  base_url:String = "https://raw.githubusercontent.com/"
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView1.layoutManager = GridLayoutManager(this,2)
        recyclerView1.setHasFixedSize(true)
        // Make Network call from the client to retrieve hit requested data
        val api = Retrofit.Builder() // build your Retrofit Object
                .baseUrl(base_url) // hit the base_url
                .addConverterFactory(GsonConverterFactory.create()) // Perform serialization and deserialization
                .build() // // Create an instance using the configured values
                .create(APIInterface::class.java)
        /* Asynchronously send the request and notify of its response or if an error
      * occurred talking to the server, creating the request, or processing the response.
      */
         api.getImages().enqueue(object : Callback<List<ImageData>> {// Make a call to hit the server
         //  to retrieve the List of ImageData
            override fun onResponse(call: Call<List<ImageData>>, response: Response<List<ImageData>>) {
                if (response!!.isSuccessful) { // Check using non null !! operator
                    // The deserialized response body of a successful response ie List<Animals>
                    myAdapter = MyAdapter(response.body()!!, applicationContext)
                    recyclerView1.adapter = myAdapter
                }
            }
            override fun onFailure(call: Call<List<ImageData>>, t: Throwable) {
                // The localized description of this throwable, like getErrorMessage from throwable
                Toast.makeText(applicationContext, "An Error Occured  ${t?.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        })
    }
}