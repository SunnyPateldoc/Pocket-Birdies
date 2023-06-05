package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R

class AdapterReviews(val list:ArrayList<String>):RecyclerView.Adapter<AdapterReviews.ViewHolder>() {

    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {

        lateinit var textRating :TextView
        lateinit var ratingBar: RatingBar
        lateinit var imageView: ImageView

        init {

            ratingBar = item.findViewById(R.id.rating_bar)
            textRating = item.findViewById(R.id.text_user_rating)
            imageView = item.findViewById(R.id.img_user_profile)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.review_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return 5 //list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.ratingBar.rating = 0.5F + position

        holder.textRating.text = "${position + 0.5}"

        //Glide.with(holder.itemView.context).load(R.drawable.profile).into(holder.imageView)


    }

}