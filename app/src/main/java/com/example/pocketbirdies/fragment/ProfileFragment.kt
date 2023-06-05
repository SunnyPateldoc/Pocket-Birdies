package com.example.pocketbirdies.fragment

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home

class ProfileFragment : Fragment() {

    lateinit var btEditProfile :TextView
    lateinit var imgUserProfile : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity = (requireActivity() as AppCompatActivity)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_feather_menu)

       val view = inflater.inflate(R.layout.fragment_profile, container, false)

        imgUserProfile = view.findViewById(R.id.img_user_profile)

        Glide.with(requireContext()).load(R.drawable.profile).circleCrop().into(imgUserProfile)


        btEditProfile = view.findViewById(R.id.bt_edit_profile)

        btEditProfile.setOnClickListener {


            findNavController().navigate(R.id.editProfileFragment)

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




}