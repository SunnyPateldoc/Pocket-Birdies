package com.example.pocketbirdies.fragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterInstructors
import com.example.pocketbirdies.model.ModelInstructors

class FindLessonFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var btLesson : TextView
    lateinit var btMessage : TextView
    lateinit var btRating : TextView

    private val args : FindLessonFragmentArgs by navArgs<FindLessonFragmentArgs>()

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

        val view = inflater.inflate(R.layout.fragment_find_lesson, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)

        val data = args.findInstrocter


        val list = ArrayList<ModelInstructors>()

        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        //list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=John+Doe&size=250","John Doe","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
       // list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=John+Doe&size=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        //  list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=Rick+Shiels&size=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://eu.ui-avatars.com/api/?name=Sunny+Patel&size=250","Sunny Patel","TPC Scottsdale, AZ",false))
        list.add(ModelInstructors("https://www.gravatar.com/avatar/2c7d99fe281ecd3bcd65ab915bac6dd5?s=250","Rick Shiels","TPC Scottsdale, AZ",false))


        list[list.indexOf(data)].isSelected = true


        val adapter = AdapterInstructors(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter


        val pos = list.withIndex().filter { it.value.isSelected == true }.map { it.index }

        recyclerView.scrollToPosition(pos[0])

        adapter.setOnClickListener(object :AdapterInstructors.onClickListener{
            override fun onClick(data: ModelInstructors, position: Int) {

                if (data.isSelected){

                    if (findNavController().currentDestination!!.id == R.id.find_lesson){

                        findNavController().navigate(R.id.dialogFragment,DialogFragmentArgs(data).toBundle())

                    }


                    recyclerView.scrollToPosition(position)
                    adapter.notifyDataSetChanged()
                }

            }

        })

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_filter -> { findNavController().navigate(R.id.filterFragment)}
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()

        inflater.inflate(R.menu.find_lesson_menu,menu)

        super.onCreateOptionsMenu(menu, inflater)
    }


}