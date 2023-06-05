package com.example.pocketbirdies.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterMessages
import com.example.pocketbirdies.model.ModelInstructors
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MessagesFragment : Fragment() {

    lateinit var btNewMessage: FloatingActionButton

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)

        val activity = (requireActivity() as Home)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_feather_menu)

        btNewMessage = view.findViewById(R.id.floatingActionButton)

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


        val adapter = AdapterMessages(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        adapter.setOnClickLisstner(object : AdapterMessages.onClickListner {
            override fun onClick(pos: ModelInstructors) {

                if (pos.isSelected){

                    activity.setChatTitle(pos.imageProfile,pos.nameInstructors)

                    if (findNavController().currentDestination!!.id == R.id.massages){

                        findNavController().navigate(R.id.chatFragment,ChatFragmentArgs(pos).toBundle())

                    }

                    //list[list.indexOf(pos)].isSelected = true

                    //adapter.notifyDataSetChanged()
                }

            }


        })



        btNewMessage.setOnClickListener {

            findNavController().navigate(R.id.newMessageFragment)

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