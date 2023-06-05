package com.example.pocketbirdies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R

class AdapterNotification(val list:ArrayList<String>):RecyclerView.Adapter<AdapterNotification.ViewHolder>() {


    class ViewHolder(item:View):RecyclerView.ViewHolder(item) {

        init {



        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



    }


    override fun getItemViewType(position: Int): Int {

        when(list[position]){
            "Notification" -> return R.layout.notification_layout
            "Lesson booking" -> return R.layout.booking_confirm_notification_layout
            "Message" -> return R.layout.chat_notification_layout
            "upcoming" -> return R.layout.upcoming_lesson_notification_layout
            "Lesson completed" -> return R.layout.lesson_completed_notification_layout
            else ->  return R.layout.notification_layout
        }



    }

}