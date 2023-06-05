package com.example.pocketbirdies.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pocketbirdies.fragment.CompletedFragment
import com.example.pocketbirdies.fragment.PendingFragment
import com.example.pocketbirdies.fragment.UpcomingFragment

class TabAdapter (fm : FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Upcoming"
            }
            1 -> {
                return "Completed"
            }
            2 -> {
                return "Pending"
            }
        }
        return super.getPageTitle(position)
    }

    override fun getItem(position: Int): Fragment {

        when(position) {
            0 -> {
                return UpcomingFragment()
            }
            1 -> {
                return CompletedFragment()
            }
            2 -> {
                return PendingFragment()
            }
            else -> {
                return UpcomingFragment()
            }
        }
    }


}