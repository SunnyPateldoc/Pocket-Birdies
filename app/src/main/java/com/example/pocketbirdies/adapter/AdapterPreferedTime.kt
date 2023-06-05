package com.example.pocketbirdies.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R
import org.w3c.dom.Text

class AdapterPreferedTime(val list: ArrayList<String>) :
    RecyclerView.Adapter<AdapterPreferedTime.ViewHolder>() {


    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        lateinit var textTime : TextView

        init {

            textTime = item.findViewById(R.id.text_time)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.prefered_time, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return 7 //list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textTime.setText("11:30 AM - 12:00 PM")

        holder.textTime.setOnClickListener {

            holder.textTime.background = holder.itemView.context.getDrawable(R.drawable.text_backgound_fill)
            holder.textTime.typeface = Typeface.DEFAULT_BOLD

        }

    }


}