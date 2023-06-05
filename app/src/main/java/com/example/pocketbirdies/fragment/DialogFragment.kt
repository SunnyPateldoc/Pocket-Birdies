package com.example.pocketbirdies.fragment

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pocketbirdies.ItemHomeDirections
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class DialogFragment : BottomSheetDialogFragment() {

    lateinit var imgInstrocterProfile : ImageView
    lateinit var imgProfilea : ImageView
    lateinit var imgProfileb : ImageView
    lateinit var imgProfilec : ImageView
    lateinit var btLesson : TextView
    lateinit var btMessage : TextView
    lateinit var btRating : TextView

    private val args : DialogFragmentArgs by navArgs<DialogFragmentArgs>()

    private lateinit var textInstroctorName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog!!.setCanceledOnTouchOutside(false)


        val view = inflater.inflate(R.layout.fragment_dialog, container, false)

        btLesson = view.findViewById(R.id.text_lessons)
        btMessage = view.findViewById(R.id.text_message)
        btRating = view.findViewById(R.id.text_average_rating)

        textInstroctorName = view.findViewById(R.id.text_title_instructors_name)

        imgInstrocterProfile = view.findViewById(R.id.img_instructor_profile)
        imgProfilea = view.findViewById(R.id.img_users_1)
        imgProfileb = view.findViewById(R.id.img_users_2)
        imgProfilec = view.findViewById(R.id.img_users_3)

        val data = args.dialogInstroctor

        Glide.with(requireContext()).load(data.imageProfile).circleCrop().into(imgInstrocterProfile)

        textInstroctorName.setText(data.nameInstructors)

        Glide.with(requireContext()).load(R.drawable.profile).circleCrop().into(imgProfilea)
        Glide.with(requireContext()).load(R.drawable.profile).circleCrop().into(imgProfileb)
        Glide.with(requireContext()).load(R.drawable.profile).circleCrop().into(imgProfilec)


        btLesson.setOnClickListener {

            findNavController().navigate(R.id.lessonFragment,LessonFragmentArgs(data).toBundle())


        }

        btRating.setOnClickListener {

            findNavController().navigate(R.id.reviewsFragment)

        }

        btMessage.setOnClickListener {

            (requireActivity() as Home).setChatTitle(data.imageProfile,data.nameInstructors)

           // val direction = Uri.parse("navapp://message/chate")
            //val pass = ItemHomeDirections.actionItemHomeToItemMessage()
            findNavController().navigate(ItemHomeDirections.actionItemHomeToItemMessage())

            findNavController().navigate(R.id.chatFragment,ChatFragmentArgs(data).toBundle())
        }


        return view
    }


}