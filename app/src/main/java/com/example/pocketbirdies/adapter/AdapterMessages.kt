package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.pocketbirdies.R
import com.example.pocketbirdies.model.ModelInstructors

class AdapterMessages(val list:ArrayList<ModelInstructors>):RecyclerView.Adapter<AdapterMessages.ViewHolder>() {

    var mListner : onClickListner? = null

    interface onClickListner{

        fun onClick(pos: ModelInstructors)

    }

    fun setOnClickLisstner(listner: onClickListner){

        mListner = listner

    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {

        val image :ImageView
        val name :TextView

        init {

            image = item.findViewById(R.id.img_profile)
            name = item.findViewById(R.id.text_name_message)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.messages_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val  pos = list[position]

        pos.isSelected = pos.isSelected
       // Glide.with(holder.itemView.context).load(R.drawable.chat_banner).transform(CenterCrop(),RoundedCorners(50)).into(holder.image)
        Glide.with(holder.itemView.context).load(pos.imageProfile).circleCrop().into(holder.image)
        holder.name.setText(pos.nameInstructors)

        if (!pos.isSelected){
            holder.itemView.setBackgroundResource(R.color.pink_li)
        }else{
            holder.itemView.setBackgroundResource(R.color.white)
        }

        holder.itemView.setOnClickListener {

            pos.isSelected = true

            mListner?.onClick(pos)

            notifyDataSetChanged()


        }


    }


}