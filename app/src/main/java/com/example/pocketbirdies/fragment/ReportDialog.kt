package com.example.pocketbirdies.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R


class ReportDialog : androidx.fragment.app.DialogFragment() {


    lateinit var textInappropriateLanguage :TextView
    lateinit var textHarement :TextView
    lateinit var textSpam :TextView
    lateinit var textUnreleterdMessage :TextView
    lateinit var textOther :TextView
    lateinit var textCencle :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE,R.style.MyDialog)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report_dialog, container, false)

        textInappropriateLanguage = view.findViewById(R.id.text_inappropriate_language)
        textHarement = view.findViewById(R.id.text_harrassment)
        textSpam = view.findViewById(R.id.text_spam)
        textUnreleterdMessage = view.findViewById(R.id.text_unrelated_messages)
        textOther = view.findViewById(R.id.text_other)
        textCencle = view.findViewById(R.id.text_cancle)



        textInappropriateLanguage.setOnClickListener {

            findNavController().navigate(R.id.notifyDialog)

            onPause()



        }
        textSpam.setOnClickListener {

            findNavController().navigate(R.id.notifyDialog)

            onPause()



        }
        textUnreleterdMessage.setOnClickListener {

            findNavController().navigate(R.id.notifyDialog)

            onPause()



        }
        textHarement.setOnClickListener {

            findNavController().navigate(R.id.notifyDialog)

            onPause()



        }
        textOther.setOnClickListener {

            findNavController().navigate(R.id.otherDialog)

            onPause()



        }
        textCencle.setOnClickListener {

            dismiss()

        }



        return view
    }



    override fun onPause() {

        if (dialog!!.isShowing){
            dialog!!.hide()
        }

        super.onPause()
    }




}