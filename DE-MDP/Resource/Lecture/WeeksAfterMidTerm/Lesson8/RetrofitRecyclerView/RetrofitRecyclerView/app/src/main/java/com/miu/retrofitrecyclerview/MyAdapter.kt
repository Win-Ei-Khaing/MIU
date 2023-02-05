package com.miu.retrofitrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_data.view.*

class MyAdapter(var list:List<ImageData>,var context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_data,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.text.text = list[position].name
        Glide.with(context).load(list[position].imageurl).into(holder.itemView.image)
    }

    override fun getItemCount() = list.size
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}