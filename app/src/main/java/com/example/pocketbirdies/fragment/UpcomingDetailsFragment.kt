package com.example.pocketbirdies.fragment

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home


class UpcomingDetailsFragment : Fragment() {

    lateinit var btBookingCancel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity = (requireActivity() as AppCompatActivity)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(false)

        val view = inflater.inflate(R.layout.fragment_upcoming_details, container, false)


        btBookingCancel = view.findViewById(R.id.bt_cancel_booking)

        btBookingCancel.setOnClickListener {

            var dialoglayout =
                LayoutInflater.from(requireContext())
                    .inflate(R.layout.cancel_booking_dialogbox, null)

            /* var dialog = Dialog(requireContext())
             dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
             dialog.setContentView(dialoglayout)
             dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
             dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))*/

            var dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(dialoglayout)
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            var btNo = dialog.findViewById(R.id.bt_no) as TextView
            var btYes = dialog.findViewById(R.id.bt_yes) as TextView
            dialog.show()

            btNo.setOnClickListener {

                dialog.dismiss()

            }


            btYes.setOnClickListener {

                dialog.dismiss()
                /*val direction =
                    ReviewDetailsFragmentDirections.actionReviewDetailsFragmentToCardDetailsFragment()
                findNavController().navigate(direction)*/

            }

        }


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()



        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onResume() {
        super.onResume()

        val activity = (requireActivity() as Home)

        val isBottome = activity.isBottomViewVisible
        val isHome = activity.isHomeActionBar
        val isSecond = activity.isSecondActionBar
        val isChat = activity.isChatActionBar
        val getTitle = activity.setTitle
        val getBack = activity.setBack

        activity.setFragmetActive(isBottome, isHome, isSecond, isChat, getTitle, getBack)
    }

}