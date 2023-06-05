package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R
import com.example.pocketbirdies.model.ModelInstructors

class AdapterNearmeInstructors(var list: ArrayList<ModelInstructors>) : RecyclerView.Adapter<AdapterNearmeInstructors.ViewHolder>() {

    private var onListener: onClickListener? = null


    interface onClickListener{

        fun onClick(b: ModelInstructors)

    }

    fun setOnClickListener(listener: onClickListener){

        onListener = listener

    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

         var imgInstructorProfile: ImageView
         var textInstructorsName: TextView
         var textInstructorsGolfClube: TextView


        init {

            imgInstructorProfile = item.findViewById(R.id.img_instructor)
            textInstructorsName = item.findViewById(R.id.text_title_instructors_name)
            textInstructorsGolfClube = item.findViewById(R.id.text_title_golf_club)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.nearby_instructors_layout, parent, false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pos = list[position]

        Glide.with(holder.itemView.context)
            .load(pos.imageProfile).circleCrop()
            .into(holder.imgInstructorProfile)

        holder.textInstructorsName.setText(pos.nameInstructors)
        holder.textInstructorsGolfClube.setText(pos.nameCenter)

        holder.itemView.setOnClickListener {

            onListener?.onClick(pos)

        }

    }



}