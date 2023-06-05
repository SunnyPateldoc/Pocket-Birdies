package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.os.PatternMatcher
import android.util.Patterns
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home


class EmailAddressFragment : Fragment() {

    lateinit var edtEmail :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_email_address, container, false)


        edtEmail = view.findViewById(R.id.edt_email)

       /* (requireActivity() as Home).textOption.setOnClickListener {

            val email = edtEmail.text.toString()

            if (email.isEmpty()){

                (requireActivity() as Home).onSnackBar("Please enter email")

            }else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                (requireActivity() as Home).onSnackBar("Please enter valid email")

            }else{



            }


        }
*/

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