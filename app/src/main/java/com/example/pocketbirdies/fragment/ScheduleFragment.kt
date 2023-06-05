package com.example.pocketbirdies.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager.widget.ViewPager
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout


class ScheduleFragment : Fragment() {

    lateinit var tabLayout : TabLayout
    lateinit var pager: ViewPager

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_schedule, container, false)

        val activity = (requireActivity() as AppCompatActivity)

        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar!!.setDisplayShowHomeEnabled(true)
        activity.supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_feather_menu)

        tabLayout = view.findViewById(R.id.tabLayout)

        pager = view.findViewById(R.id.viewPager)

        pager.adapter = TabAdapter(childFragmentManager)

        tabLayout.setupWithViewPager(pager)

        /*val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_view_home) as NavHostFragment

        navController = navHostFragment.navController*/




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