package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home


class CardDetailsFragment : Fragment() {

    lateinit var btUseCard: TextView
    lateinit var edtCardName: EditText
    lateinit var edtCardNumber: EditText
    lateinit var edtExpiMonth: EditText
    lateinit var edtExpiYear: EditText
    lateinit var edtCvc: EditText


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


        val view = inflater.inflate(R.layout.fragment_card_details, container, false)

        btUseCard = view.findViewById(R.id.bt_use_this_card)


        edtCardNumber = view.findViewById(R.id.edt_card_number)
        edtCardName = view.findViewById(R.id.edt_name_on_card)
        edtExpiMonth = view.findViewById(R.id.edt_expiration_mont)
        edtExpiYear = view.findViewById(R.id.edt_expiration_year)
        edtCvc = view.findViewById(R.id.edt_cvc)







        btUseCard.setOnClickListener {

            val cardNumber = edtCardNumber.text.toString()
            val cardName = edtCardName.text.toString()
            val cardExpiMonth = edtExpiMonth.text.toString()
            val cardExpiYear = edtExpiYear.text.toString()
            val cardCvc = edtCvc.text.toString()


            if (cardName.isNullOrEmpty()) {
                (requireActivity() as Home).onSnackBar("Please enter card holder name")
            } else if (cardNumber.isNullOrEmpty()) {
                (requireActivity() as Home).onSnackBar("Please enter card number")
            } else if (cardNumber.length != 14) {
                (requireActivity() as Home).onSnackBar("Please enter valid card number")
            } else if (cardExpiMonth.isNullOrEmpty()) {
                (requireActivity() as Home).onSnackBar("Please enter card expiry month")
            } else if (cardExpiYear.isNullOrEmpty()) {
                (requireActivity() as Home).onSnackBar("Please enter card expiry year")
            } else if (cardExpiYear.length != 4) {
                (requireActivity() as Home).onSnackBar("Please enter valid card expiry year")
            } else if (cardCvc.isNullOrEmpty()) {
                (requireActivity() as Home).onSnackBar("Please enter card cvc")
            } else if (cardCvc.length != 3) {
                (requireActivity() as Home).onSnackBar("Please enter valid card cvc")
            } else {
                findNavController().navigate(R.id.paymentFragment)
            }


        }



        return view
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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()


        super.onCreateOptionsMenu(menu, inflater)
    }

}