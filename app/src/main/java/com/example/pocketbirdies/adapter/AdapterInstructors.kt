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

class AdapterInstructors(var list: ArrayList<ModelInstructors>) :
    RecyclerView.Adapter<AdapterInstructors.ViewHolder>() {

    private var onListener: onClickListener? = null


    interface onClickListener{

        fun onClick(pos: ModelInstructors, position: Int)

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

        return ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pos = list[position]

        pos.isSelected = pos.isSelected

        Glide.with(holder.itemView.context)
            .load(pos.imageProfile).circleCrop()
            .into(holder.imgInstructorProfile)

        holder.textInstructorsName.setText(pos.nameInstructors)
        if (pos.isSelected){
            holder.textInstructorsGolfClube.setText(pos.nameCenter)

        }

        holder.itemView.setOnClickListener {

            if (pos.isSelected){

                for (data in list){
                    data.isSelected = false
                }
                pos.isSelected = true

                onListener?.onClick(pos,position)


            }else{
                for (data in list){
                    data.isSelected = false
                }
                pos.isSelected = true

                onListener?.onClick(pos,position)


            }

            notifyDataSetChanged()

        }


    }

    override fun getItemViewType(position: Int): Int {

        val pos = list[position]

        if (pos.isSelected){


            return R.layout.instructors_selected_layout

        }else {

            return R.layout.instructors_layout

        }


    }

}