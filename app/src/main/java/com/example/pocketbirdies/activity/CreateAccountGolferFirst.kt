package com.example.pocketbirdies.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import com.example.pocketbirdies.R
import com.google.android.material.snackbar.Snackbar

class CreateAccountGolferFirst : AppCompatActivity() {


    lateinit var btContinue: TextView
    lateinit var imgBack: ImageView

    lateinit var edtEmail: EditText
    lateinit var edtNewPassword: EditText
    lateinit var edtConfirmPassword: EditText

    lateinit var root: ScrollView
    val nameShare = "PocketBirdies"
    val keyEmai = "email"
    val keyPassword = "pasword"
    val keyLogin = "login"
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account_golfer_first)

        // sharedPreferences = getSharedPreferences(nameShare,Context.MODE_PRIVATE)

        root = findViewById(R.id.scroll_view)
        btContinue = findViewById(R.id.bt_continue)
        imgBack = findViewById(R.id.image_back)

        edtEmail = findViewById(R.id.edt_email)
        edtNewPassword = findViewById(R.id.edt_new_password)
        edtConfirmPassword = findViewById(R.id.edt_confirm_password)

        imgBack.setOnClickListener {

            this.onBackPressed()

        }

        btContinue.setOnClickListener {

            //startActivity(Intent(applicationContext,CreateAccountGolferSecond::class.java))

            getValidetion()

        }

    }

    private fun getValidetion() {

        val email = edtEmail.text.toString()
        val newPassword = edtNewPassword.text.toString()
        val confirmPassword = edtConfirmPassword.text.toString()

        if (email.isNullOrEmpty()) {

            edtEmail.error = "Email is Empty"
            edtEmail.isFocusable
            onSnackBar("Email is Empty")

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            edtEmail.error = "Email is not valid!"
            edtEmail.isFocusable
            onSnackBar("Email is not valid!")

        } else if (newPassword.isNullOrEmpty()) {

            edtNewPassword.error = "Password is empty!"
            edtNewPassword.isFocusable
            onSnackBar("Password is empty!")

        } else if (newPassword.length < 8) {

            edtNewPassword.error = "Password must be 8 !"
            edtNewPassword.isFocusable
            onSnackBar("Password must be 8!")

        } else if (confirmPassword.isNullOrEmpty()) {

            edtConfirmPassword.error = "Confirm Password is empty!"
            edtConfirmPassword.isFocusable
            onSnackBar("Confirm Password is empty!")

        } else if (confirmPassword != newPassword) {

            edtNewPassword.error = "Password dose not matche!"
            edtNewPassword.isFocusable
            edtConfirmPassword.error = "Password dose not matche!"
            edtConfirmPassword.isFocusable
            onSnackBar("Password dose not matche!")
            
        } else {

            val i = Intent(applicationContext, CreateAccountGolferSecond::class.java)
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