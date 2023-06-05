package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home


class UpdatePasswordFragment : Fragment() {

    lateinit var edtCurrentPassord : EditText
    lateinit var edtNewPassord : EditText
    lateinit var edtConfirmPassord : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update_password, container, false)

        edtCurrentPassord = view.findViewById(R.id.edt_current_password)
        edtNewPassord = view.findViewById(R.id.edt_new_password)
        edtConfirmPassord = view.findViewById(R.id.edt_confirm_password)


       /* (requireActivity() as Home).textOption.setOnClickListener {

            val currentPasword = edtCurrentPassord.text.toString()
            val newPasword = edtNewPassord.text.toString()
            val confirmPasword = edtConfirmPassord.text.toString()

            if (currentPasword.isNullOrEmpty()){
                (requireActivity() as Home).onSnackBar("Please enter current password")
            }else if (newPasword.isNullOrEmpty()){
                (requireActivity() as Home).onSnackBar("Please enter new password")
            }else if (newPasword.length < 8){
                (requireActivity() as Home).onSnackBar("Please enter new password min 8")
            }else if (confirmPasword.isNullOrEmpty()){
                (requireActivity() as Home).onSnackBar("Please enter confirm password")
            }else if (newPasword == confirmPasword){
                (requireActivity() as Home).onSnackBar("Not match new password and confirm password")
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