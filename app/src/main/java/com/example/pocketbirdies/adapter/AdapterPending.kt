package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R

class AdapterPending(val list: ArrayList<String>):RecyclerView.Adapter<AdapterPending.ViewHolder>() {


    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {

        init {



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pending_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return 3 //list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }


}