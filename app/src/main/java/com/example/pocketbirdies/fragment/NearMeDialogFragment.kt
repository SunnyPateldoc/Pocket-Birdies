package com.example.pocketbirdies.fragment

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.ItemNearmeDirections
import com.example.pocketbirdies.R
import com.example.pocketbirdies.adapter.AdapterNearMe
import com.example.pocketbirdies.model.ModelInstructors
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NearMeDialogFragment : BottomSheetDialogFragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_near_me_dialog, container, false)

        dialog!!.setCanceledOnTouchOutside(false)

        view.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.bottom_sheet_background))


        recyclerView = view.findViewById(R.id.recycler_view)


        val list = ArrayList<ModelInstructors>()

        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        //list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=John+Doe&size=250","John Doe","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        // list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=John+Doe&size=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
//        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=Rick+Shiels&size=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=Sunny+Patel&size=250","Sunny Patel","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))




        val adapter = AdapterNearMe(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter


        adapter.setOnClickListner(object : AdapterNearMe.onClickListner{
            override fun onClick(pos: ModelInstructors) {

                if (findNavController().currentDestination!!.id == R.id.nearme){

                    findNavController().navigate(ItemNearmeDirections.actionGlobalItemHome())

                    findNavController().navigate(R.id.find_lesson,FindLessonFragmentArgs(pos).toBundle())


                }

            }

        })


        return view
    }

    override fun onStart() {

        dialog!!.getWindow()!!.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)

        dialog!!.getWindow()!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)


        super.onStart()
    }


}