package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R

class AdapterNewMessage(val list:ArrayList<String>):RecyclerView.Adapter<AdapterNewMessage.ViewHolder>() {

    var mListner : onClickListner? = null

    interface onClickListner{

        fun onClick()

    }

    fun setOnClickListner(listner: onClickListner){

        mListner = listner

    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {

        init {



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.new_messages_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return 5 //list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemView.setOnClickListener {

            mListner?.onClick()

        }


    }


}