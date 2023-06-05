package com.example.pocketbirdies.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.pocketbirdies.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class CreateAccountGolferSecond : AppCompatActivity() {

    lateinit var btContinue: TextView

    lateinit var autoTextCompleteYearOfGolferExpe: AutoCompleteTextView
    lateinit var autoTextCompleteGolfHandicap: AutoCompleteTextView
    lateinit var autoTextCompleteHomeCourse: AutoCompleteTextView
    lateinit var imgBack: ImageView

    lateinit var edtFirstName : EditText
    lateinit var edtLastName : EditText
    lateinit var edtAge : EditText

    lateinit var root: ScrollView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account_golfer_second)

        imgBack = findViewById(R.id.image_back)

        root = findViewById(R.id.scroll_view)

        autoTextCompleteYearOfGolferExpe = findViewById(R.id.auto_text_complete_years_of_golf_experience)
        autoTextCompleteGolfHandicap = findViewById(R.id.auto_text_complete_golf_handicap)
        autoTextCompleteHomeCourse = findViewById(R.id.auto_text_complete_home_course)

        edtFirstName = findViewById(R.id.edt_first_name)
        edtLastName = findViewById(R.id.edt_last_name)
        edtAge = findViewById(R.id.edt_age)


        btContinue = findViewById(R.id.bt_continue)

        imgBack.setOnClickListener {

            this.onBackPressed()

        }

        btContinue.setOnClickListener {

            //startActivity(Intent(applicationContext,SuccessSecond::class.java))

            getValidation()

        }

        onAutoTextComplete()

    }

    private fun onAutoTextComplete() {

        val itemYear = listOf("N/A", "0to3", "3to5", "5above")
        val adapterYear = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_activated_1,
            itemYear
        )

        autoTextCompleteYearOfGolferExpe.setAdapter(adapterYear)


        val itemHandicap = listOf("N/A", "0to3", "3to5", "5above")
        val adapterHandicap = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_activated_1,
            itemHandicap
        )

        autoTextCompleteGolfHandicap.setAdapter(adapterHandicap)


        val itemCourse = listOf("N/A", "0to3", "3to5", "5above")
        val adapterCourse = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_activated_1,
            itemCourse
        )

        autoTextCompleteHomeCourse.setAdapter(adapterCourse)
    }

    private fun getValidation() {

        val firstName = edtFirstName.text.toString()
        val lastName = edtLastName.text.toString()
        val age = edtAge.text.toString()
        val yearOfGolfExpi = autoTextCompleteYearOfGolferExpe.text.toString()
        val golfHandicap = autoTextCompleteGolfHandicap.text.toString()
        val homeCourse = autoTextCompleteHomeCourse.text.toString()

        if (firstName.isNullOrEmpty()){
            edtFirstName.error = "First Name is empty"
            edtFirstName.isFocusable
            onSnackBar("First Name is empty")

        }else if (lastName.isNullOrEmpty()){

            edtLastName.error = "Last Name is empty"
            edtLastName.isFocusable
            onSnackBar("Last Name is empty")

        }else if (age.isNullOrEmpty()){

            edtAge.error = "Age is empty"
            edtAge.isFocusable
            onSnackBar("Age is empty")

        }else if (yearOfGolfExpi.isNullOrEmpty()){
            autoTextCompleteYearOfGolferExpe.error = "Years of Golf Experience is empty"
            autoTextCompleteYearOfGolferExpe.isFocusable
            onSnackBar("Years of Golf Experience is empty")

        }else if (golfHandicap.isNullOrEmpty()){

            autoTextCompleteGolfHandicap.error = "Golf Handicap is empty"
            autoTextCompleteGolfHandicap.isFocusable
            onSnackBar("Golf Handicap is empty")

        }else if (homeCourse.isNullOrEmpty()){

            autoTextCompleteHomeCourse.error = "Home Course is empty"
            autoTextCompleteHomeCourse.isFocusable
            onSnackBar("Home Course is empty")

        }else{

            val i = Intent(applicationContext, SuccessSecond::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
        }




    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun onSnackBar(message: String) {
        Snackbar.make(root, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(getColor(R.color.black_gray))
            .setTextColor(getColor(R.color.white))
            .show()
    }
}