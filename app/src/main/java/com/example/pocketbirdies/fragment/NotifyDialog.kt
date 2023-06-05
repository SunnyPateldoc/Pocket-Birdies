package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R


class NotifyDialog : androidx.fragment.app.DialogFragment() {

    lateinit var textClose: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NO_TITLE, R.style.MyDialog)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notify_dialog, container, false)


        textClose = view.findViewById(R.id.text_close)

        textClose.setOnClickListener {

            findNavController().popBackStack()
            findNavController().popBackStack()
            findNavController().popBackStack()
            findNavController().navigate(R.id.item_massages)


        }

        return view
    }

    override fun onPause() {

        if (dialog!!.isShowing) {
            dialog!!.hide()
        }

        super.onPause()
    }

    override fun onAttach(context: Context) {


        super.onAttach(context)
    }

    override fun onDetach() {

        findNavController().navigateUp()


        super.onDetach()
    }
}