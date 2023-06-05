package com.example.pocketbirdies.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pocketbirdies.R
import androidx.fragment.app.DialogFragment


class BlockDialog : DialogFragment() {

    lateinit var textCencle : TextView

    lateinit var textYes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE,R.style.MyDialog)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_block_dialog, container, false)


        textCencle = view.findViewById(R.id.text_cencle)
        textYes = view.findViewById(R.id.text_yes)

        textCencle.setOnClickListener {
            dismiss()
        }

        textYes.setOnClickListener {
            dismiss()
        }



        return view
    }


}