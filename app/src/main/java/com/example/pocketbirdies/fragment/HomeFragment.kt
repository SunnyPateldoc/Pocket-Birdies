package com.example.pocketbirdies.fragment

import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.ItemHomeDirections
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterNearmeInstructors
import com.example.pocketbirdies.model.ModelInstructors
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class HomeFragment : Fragment() {

    lateinit var imgFindLesson :ImageView
    lateinit var imgChat :ImageView
    lateinit var imgAtHome :ImageView
    lateinit var recyclerView: RecyclerView

    var list = ArrayList<ModelInstructors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)



        val activity = (requireActivity() as AppCompatActivity)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_feather_menu)


        imgAtHome = view.findViewById(R.id.img_at_home_program_banner)
        imgFindLesson = view.findViewById(R.id.img_find_a_lesson)
        imgChat = view.findViewById(R.id.img_chat_banner)

        recyclerView = view.findViewById(R.id.recycler_view_near_me)

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


        //GridLayoutManager(requireContext(),2,GridLayoutManager.HORIZONTAL,false)
        val adapter = AdapterNearmeInstructors(list)
        recyclerView.layoutManager = FlexboxLayoutManager(requireContext(), FlexDirection.ROW,FlexWrap.WRAP)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(object :AdapterNearmeInstructors.onClickListener{
            override fun onClick(data: ModelInstructors) {
                
                if (findNavController().currentDestination!!.id == R.id.home){

                    findNavController().navigate(R.id.find_lesson,FindLessonFragmentArgs(data).toBundle())

                }

            }

        })

        imgFindLesson.setOnClickListener {


            findNavController().navigate(R.id.find_lesson)

        }
        imgAtHome.setOnClickListener {

            val direction = HomeFragmentDirections.actionItemHomeToComingSoon()
            findNavController().navigate(direction)

        }

        imgChat.setOnClickListener {

            val direction = Uri.parse("navapp://message/message")
            if (findNavController().currentDestination!!.id == R.id.home){

                findNavController().navigate(ItemHomeDirections.actionItemHomeToItemMessage())

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


}