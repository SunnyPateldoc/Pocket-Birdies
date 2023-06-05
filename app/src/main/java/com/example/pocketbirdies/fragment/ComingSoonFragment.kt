package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterReviews
import com.example.pocketbirdies.adapter.AdapterTutoarial

class ComingSoonFragment : Fragment() {

    lateinit var recyclerView :RecyclerView

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

        val  view = inflater.inflate(R.layout.fragment_coming_soon, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)

        val list = ArrayList<String>()

        val adapter = AdapterTutoarial(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter



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