package com.example.pocketbirdies.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.adapter.AdapterNearmeInstructors
import com.example.pocketbirdies.adapter.AdapterReviews

class ReviewsFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var retingBar : RatingBar

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

        val view = inflater.inflate(R.layout.fragment_reviews, container, false)

        retingBar = view.findViewById(R.id.rating_bar)
        recyclerView = view.findViewById(R.id.recycler_view)

        retingBar.rating = 2.5F


        val list = ArrayList<String>()

        val adapter = AdapterReviews(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter


        //(requireActivity() as Home).textOption.setOnClickListener { findNavController().navigate(ReviewsFragmentDirections.actionReviewsFragmentToAddReviewFragment()) }


        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_add_reviews -> { findNavController().navigate(R.id.reviewsFragment) }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()

        inflater.inflate(R.menu.reviews_menu,menu)
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