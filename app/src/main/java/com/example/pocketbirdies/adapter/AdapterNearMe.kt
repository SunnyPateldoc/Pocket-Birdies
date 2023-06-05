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

class AdapterNearMe(val list:ArrayList<ModelInstructors>):RecyclerView.Adapter<AdapterNearMe.ViewHolder>() {

    var mListner : onClickListner? = null


    interface onClickListner{

        fun onClick(pos: ModelInstructors)

    }

    fun setOnClickListner(listner: onClickListner){
        mListner = listner
    }

    class ViewHolder(item : View):RecyclerView.ViewHolder(item) {

         var imgInstructorProfile: ImageView
         var textIstroctorname: TextView
         var textIstroctorCeter: TextView

        init {

            imgInstructorProfile = item.findViewById(R.id.img_profile)
            textIstroctorname = item.findViewById(R.id.text_name)
            textIstroctorCeter = item.findViewById(R.id.text_golf_club_name)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.near_me_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return   list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pos = list[position]


        Glide.with(holder.itemView.context).load(pos.imageProfile).circleCrop().into(holder.imgInstructorProfile)

        holder.textIstroctorCeter.setText(pos.nameCenter)
        holder.textIstroctorname.setText(pos.nameInstructors)

        holder.itemView.setOnClickListener{

            mListner?.onClick(pos)

        }

    }
}