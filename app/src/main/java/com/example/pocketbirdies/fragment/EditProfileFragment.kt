package com.example.pocketbirdies.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pocketbirdies.R
import com.example.pocketbirdies.activity.Home
import com.example.pocketbirdies.activity.SuccessSecond


class EditProfileFragment : Fragment() {


    lateinit var imgUserProfile: ImageView

    lateinit var edtUserFirstName: EditText
    lateinit var edtUserLastName: EditText
    lateinit var edtUserAge: EditText
    lateinit var spinnerCompleteYearOfGolferExpe: Spinner
    lateinit var spinnerCompleteGolfHandicap: Spinner
    lateinit var spinnerCompleteHomeCourse: Spinner
    lateinit var edtUserBio: EditText

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

        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        imgUserProfile = view.findViewById(R.id.img_user_profile)

        Glide.with(requireContext()).load(R.drawable.profile).circleCrop().into(imgUserProfile)

        edtUserFirstName = view.findViewById(R.id.edt_first_name)
        edtUserLastName = view.findViewById(R.id.edt_last_name)
        edtUserAge = view.findViewById(R.id.edt_age)

        spinnerCompleteYearOfGolferExpe = view.findViewById(R.id.spinner_complete_years_of_golf_experience)
        spinnerCompleteGolfHandicap = view.findViewById(R.id.spinner_complete_golf_handicap)
        spinnerCompleteHomeCourse = view.findViewById(R.id.spinner_complete_home_course)

        edtUserBio = view.findViewById(R.id.edt_bio)


        onAutoTextComplete()

       /* (requireActivity() as Home).textOption.setOnClickListener {

            getValidation()

        }*/






        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item_save -> { getValidation()  }
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()

        inflater.inflate(R.menu.edit_profile_menu,menu)

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

    private fun onAutoTextComplete() {

        val itemYear = listOf("N/A", "0to3", "3to5", "5above")
        val adapterYear = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, itemYear)

        //val adapterYear = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_activated_1, itemYear)

        spinnerCompleteYearOfGolferExpe.setAdapter(adapterYear)


        val itemHandicap = listOf("N/A", "0to3", "3to5", "5above")
        val adapterHandicap = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, itemHandicap)
        //val adapterHandicap = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_activated_1, itemHandicap)

        spinnerCompleteGolfHandicap.setAdapter(adapterHandicap)


        val itemCourse = listOf("N/A", "0to3", "3to5", "5above")
       // val adapterCourse = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_activated_1, itemCourse)
        val adapterCourse = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, itemCourse)

        spinnerCompleteHomeCourse.setAdapter(adapterCourse)
    }

    private fun getValidation() {

        val firstName = edtUserFirstName.text.toString()
        val lastName = edtUserLastName.text.toString()
        val age = edtUserAge.text.toString()
        val yearOfGolfExpi = spinnerCompleteYearOfGolferExpe.selectedItem.toString()
        val golfHandicap = spinnerCompleteGolfHandicap.selectedItem.toString()
        val homeCourse = spinnerCompleteHomeCourse.selectedItem.toString()

        if (firstName.isNullOrEmpty()){

            (requireActivity() as Home).onSnackBar("First Name is empty")

        }else if (lastName.isNullOrEmpty()){

            (requireActivity() as Home).onSnackBar("Last Name is empty")

        }else if (age.isNullOrEmpty()){


            (requireActivity() as Home).onSnackBar("Age is empty")

        }else if (yearOfGolfExpi.isNullOrEmpty()){

            (requireActivity() as Home).onSnackBar("Years of Golf Experience is empty")

        }else if (golfHandicap.isNullOrEmpty()){


            (requireActivity() as Home).onSnackBar("Golf Handicap is empty")

        }else if (homeCourse.isNullOrEmpty()){


            (requireActivity() as Home).onSnackBar("Home Course is empty")

        }else{


        }




    }


}