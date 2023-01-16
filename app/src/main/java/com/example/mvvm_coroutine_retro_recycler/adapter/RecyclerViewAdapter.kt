package com.example.mvvm_coroutine_retro_recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_coroutine_retro_recycler.R
import com.example.mvvm_coroutine_retro_recycler.models.RecyclerData
import com.squareup.picasso.Picasso

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    var items = ArrayList<RecyclerData>()

    fun setUpdateData(items : ArrayList<RecyclerData>) {

        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){


        val imagethumb = view.findViewById<ImageView>(R.id.imageThumb)
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val desc = view.findViewById<TextView>(R.id.tvDesc)


        fun bind(data : RecyclerData) {

            title.text = data.name
            desc.text = data.description

            val url = data.owner.avatar_url

            Picasso.get()
                .load(url)
                .into(imagethumb)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent , false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}