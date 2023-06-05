package com.example.pocketbirdies.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.view.View.OnTouchListener
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home


class PaymentFragment : Fragment() {

    lateinit var edtPromoCode : EditText
    lateinit var textPromoCodeMessage : TextView

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

        val view = inflater.inflate(R.layout.fragment_payment, container, false)

        edtPromoCode = view.findViewById(R.id.edt_promo_code)
        textPromoCodeMessage = view.findViewById(R.id.text_promo_code_message)




        edtPromoCode.setOnClickListener {
            var promoCode = edtPromoCode.text.toString()
            checkPromoCode(promoCode, edtPromoCode)

        }



        return view
    }

    private fun checkPromoCode(promoCode: String, it: EditText) {

        if (promoCode.isEmpty()) {

            edtPromoCode.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.icon_ionic_ios_close_circle_outline,
                0
            )


        } else if (promoCode == "PBCHECKOUT") {
            Toast.makeText(requireContext(),"ok",Toast.LENGTH_SHORT).show()
            it.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.baseline_check_circle_outline_24,
                0
            );

            textPromoCodeMessage.setText("*Promo Code Applied")
            textPromoCodeMessage.setTextColor(Color.GREEN)

        } else {

            it.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.icon_ionic_ios_close_circle_outline,
                0
            )

            textPromoCodeMessage.setText("*Invalid promocode")
            textPromoCodeMessage.setTextColor(Color.RED)

        }
    }

    /*fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit){

        this.setOnTouchListener { v, event ->
            var hasConsumed = false
            if (v is EditText) {
                if (event.x >= v.width - v.totalPaddingRight) {
                    if (event.action == MotionEvent.ACTION_UP) {
                        onClicked(this)
                        hasConsumed = true
                    }
                    hasConsumed = false

                }

            }
            hasConsumed
        }


    }*/

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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()


        super.onCreateOptionsMenu(menu, inflater)
    }


}