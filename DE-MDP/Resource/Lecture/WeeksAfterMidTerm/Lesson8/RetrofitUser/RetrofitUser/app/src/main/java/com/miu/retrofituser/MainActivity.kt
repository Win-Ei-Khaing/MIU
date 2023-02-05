package com.miu.retrofituser

import android.content.Context
import android.os.Bundle
import retrofit2.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.miu.retrofituser.model.ImageData
import com.miu.retrofituser.network.APIClient
import kotlinx.android.synthetic.main.row_data.view.*
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Callback
class MainActivity : AppCompatActivity() {
    lateinit var ca : CustomAdapterlist
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Make Network call from the client to retrieve hit requested data
        var call = APIClient.apiInterface().getImages()
        /* Asynchronously send the request and notify of its response or if an error
   * occurred talking to the server, creating the request, or processing the response.
   */
        call.enqueue(object : Callback<List<ImageData>> { // Make a call to hit the server
            // hit if you receive the response--> which is to retrieve the List of ImageData
            override fun onResponse(call: Call<List<ImageData>?>?, response: Response<List<ImageData>?>?) {
                if( response!!.isSuccessful){ // Check using non null !! operator
                    // The deserialized response body of a successful response ie List<Animals>
                    ca = CustomAdapterlist(response.body()!!,applicationContext)
                    gridview.adapter = ca

                }
            }
            // Unable to get a response
            override fun onFailure(call: Call<List<ImageData>?>?, t: Throwable?) {
                // The localized description of this throwable, like getErrorMessage from throwable
                Toast.makeText(applicationContext,"An Error Occured  ${t?.localizedMessage}",Toast.LENGTH_LONG).show()

            }

        })


    }
    class  CustomAdapterlist(var list:List<ImageData>, var context:Context): BaseAdapter() {

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var view : View = LayoutInflater.from(context).inflate(R.layout.row_data,null)
            var name = view.text
            var image = view.image
            // set animal name
            name.text = list[p0].name
            // set image
            Glide.with(context)
                .load(list[p0].imageurl) // Read from the Url
                .into(image) // Set into ImageView
            return view
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()

        }

        override fun getCount(): Int {
            return list.size
        }

    }
}
