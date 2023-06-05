package com.example.pocketbirdies.fragment

import android.content.Context
import android.media.Rating
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.RatingBar
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.google.android.material.snackbar.Snackbar


class AddReviewFragment : Fragment() {

    lateinit var ratingBar : RatingBar
    lateinit var edtReview : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val  view = inflater.inflate(R.layout.fragment_add_review, container, false)

        ratingBar = view.findViewById(R.id.rating_bar)
        edtReview = view.findViewById(R.id.edt_review_message)






        /*(requireActivity() as Home).textOption.setOnClickListener {



        }
*/

        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId==R.id.item_submit){

            val rating = ratingBar.rating
            val review = edtReview.text.toString()


            if (rating == null || rating <= 0){

                (requireActivity() as Home).onSnackBar("Please give rating")

            }else if (review.isNullOrEmpty()){

                (requireActivity() as Home).onSnackBar("please give some reviews")

            }else{
                findNavController().popBackStack()
                findNavController().navigate(R.id.reviewsFragment)
            }



        }

        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()

        inflater.inflate(R.menu.add_reviews_menu,menu)

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