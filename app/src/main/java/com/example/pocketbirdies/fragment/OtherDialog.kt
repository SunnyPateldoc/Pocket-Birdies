package com.example.pocketbirdies.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home


class OtherDialog : androidx.fragment.app.DialogFragment() {

    lateinit var textCencle : TextView

    lateinit var textSubmit : TextView
    lateinit var edtReason : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE,R.style.MyDialog)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_other_dialog, container, false)

        edtReason = view.findViewById(R.id.edt_reason)


        textCencle = view.findViewById(R.id.text_cencle)
        textSubmit = view.findViewById(R.id.text_submit)

        textCencle.setOnClickListener {

            ReportDialog().onResume()

            findNavController().popBackStack()
            findNavController().navigate(R.id.reportDialog)


        }

        textSubmit.setOnClickListener {

            val reason = edtReason.text.toString()

            if (reason.isNullOrEmpty()){

                (requireActivity() as Home).onSnackBar("Please give reason")

            }else{
                edtReason.setText("")
                findNavController().popBackStack()
                findNavController().navigate(R.id.notifyDialog)
                onPause()
            }




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