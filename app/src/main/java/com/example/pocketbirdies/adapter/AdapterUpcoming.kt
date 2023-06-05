package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R

class AdapterUpcoming(val list: ArrayList<String>):RecyclerView.Adapter<AdapterUpcoming.ViewHolder>() {

    var mListner : onClickListner? = null

    interface onClickListner {
        fun onClick()
    }

    fun setOnClickListner(listner: onClickListner){

        mListner = listner

    }

    class ViewHolder(item : View):RecyclerView.ViewHolder(item) {

        init {



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.upcoming_layout,parent,false))

    }

    override fun getItemCount(): Int {

        return 4 //list.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {

            mListner?.onClick()

        }


    }
}