package com.example.pocketbirdies.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import com.example.pocketbirdies.R
import com.google.android.material.snackbar.Snackbar

class LostPasswordEmail : AppCompatActivity() {

    lateinit var btContinue : TextView
    lateinit var textGotoLogin : TextView

    lateinit var edtEmail: EditText

    lateinit var root: ScrollView
    val nameShare = "PocketBirdies"
    val keyEmai = "email"
    val keyPassword = "pasword"
    val keyLogin = "login"
    val keyMobile = "mobile"
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_password_email)

        btContinue = findViewById(R.id.bt_continue)
        textGotoLogin = findViewById(R.id.text_loging_go)

        edtEmail = findViewById(R.id.edt_email)
        root = findViewById(R.id.scroll_view)

        //sharedPreferences = getSharedPreferences(nameShare,Context.MODE_PRIVATE)


        btContinue.setOnClickListener {

            //startActivity(Intent(applicationContext,Verification::class.java))
            getValidation()

        }

        textGotoLogin.setOnClickListener {

           // startActivity(Intent(applicationContext,LoginPlayer::class.java))

            val i = Intent(applicationContext, LoginPlayer::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)


        }




    }

    private fun getValidation() {

        val email = edtEmail.text.toString()

        if (email.isNullOrEmpty()) {

            edtEmail.error = "Email is Empty"
            edtEmail.isFocusable

            onSnackBar("Email is Empty")

        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Email is not valid!"
            edtEmail.isFocusable
            onSnackBar("Email is not valid!")
        } else{

            val i = Intent(applicationContext, Verification::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)

        }

    }
    private fun onSnackBar(message: String) {
        Snackbar.make(root, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(getColor(R.color.black_gray))
            .setTextColor(getColor(R.color.white))
            .show()
    }
}