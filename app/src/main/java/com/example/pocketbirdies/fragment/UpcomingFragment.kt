package com.example.pocketbirdies.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R
import com.example.pocketbirdies.adapter.AdapterReviews
import com.example.pocketbirdies.adapter.AdapterUpcoming


class UpcomingFragment : Fragment() {

    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_upcoming, container, false)


        recyclerView = view.findViewById(R.id.recycler_view)


        val list = ArrayList<String>()


        val adapter = AdapterUpcoming(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter


        adapter.setOnClickListner(object : AdapterUpcoming.onClickListner{
            override fun onClick() {

                if (findNavController().currentDestination!!.id == R.id.schedule){

                    findNavController().navigate(ScheduleFragmentDirections.actionItemScheduleToUpcomingDetailsFragment())

                }


            }


        })



        return view
    }


}