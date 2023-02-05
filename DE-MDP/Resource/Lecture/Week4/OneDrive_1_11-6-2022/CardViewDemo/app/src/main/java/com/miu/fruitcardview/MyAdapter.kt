package com.miu.fruitcardview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_layout.view.*
class MyAdapter  (var context: Context, var text1 :Array<String>, var text2:Array<String>, var img:IntArray, var text3 : Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
      /*
       holder.im.setImageResource(img[position])
        holder.t1.text = text1[position]
        holder.t2.text = text2[position]
        holder.itemView.name.text = blist[position].name
       */
       /* holder.itemView.playout.tv1.text = text1[position]
        holder.itemView.playout.tv2.text = text2[position]
        holder.itemView.playout.imageView.setImageResource(img[position])*/
        holder.itemView.playout.apply {
           tv1.text = text1[position]
           tv2.text = text2[position]
           imageView.setImageResource(img[position])
        }
        holder.itemView.playout.setOnClickListener{
            val intent = Intent(context, DetailActivity::class.java)

            var res = text1[position]
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()

            intent.putExtra("image", img[position])
            intent.putExtra("name", text1[position])
            intent.putExtra("detail",text3[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return text1.size
    }
     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}








{
    var title: TextView? = view?.findViewById(R.id.rv_title)
    var image: ImageView? = view?.findViewById(R.id.rv_image)
    var price: TextView? = view?.findViewById(R.id.rv_price)
    var color: TextView? = view?.findViewById(R.id.rv_color)
    var itemContainer: LinearLayout? = view?.findViewById(R.id.item_container)
    @SuppressLint("NotifyDataSetChanged")
    override fun onBind(position: Int) {
        super.onBind(position)
        val product = products[position]

        itemContainer?.setOnClickListener {
            Toast.makeText(context, "hi hi", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, ElectronicsDetailActivity::class.java)

            var res = products[position]
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()

            intent.putExtra("image", img[position])
            intent.putExtra("name", text1[position])
            intent.putExtra("detail",text3[position])
            context.startActivity(intent)
        }
    }
}