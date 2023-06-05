package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R

class AdapterChat(val list: ArrayList<String>) : RecyclerView.Adapter<AdapterChat.ViewHolder>() {


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var imgProfile :ImageView
        var textName :TextView

        init {

            imgProfile = item.findViewById(R.id.img_profile)
            textName = item.findViewById(R.id.text_user_name)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return if (viewType == R.layout.chat_layout_me) {
            ViewHolder(
                LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            )
        } else ViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return  list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pos = list[position]

        Glide.with(holder.itemView.context).load(R.drawable.profile).circleCrop().into(holder.imgProfile)

        holder.textName.setText(pos)


    }

    override fun getItemViewType(position: Int): Int {

        if (list[position].equals("Sunny"))
            return R.layout.chat_layout_me
        else
            return R.layout.chat_layout_other


    }

}