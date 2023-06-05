package com.example.pocketbirdies.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pocketbirdies.R
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

class LoginPlayer : AppCompatActivity() {

    lateinit var textForgotPassword: TextView
    lateinit var btCreateAccount: TextView
    lateinit var btLogin: TextView

    lateinit var edtEmail: EditText
    lateinit var edtPassword: EditText

    lateinit var root: ScrollView
//    val nameShare = "PocketBirdies"
//    val keyEmai = "email"
//    val keyPassword = "pasword"
//    val keyLogin = "login"
//    var sharedPreferences: SharedPreferences? = null

    //val emailPattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\$"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_player)

        //sharedPreferences = getSharedPreferences(nameShare, Context.MODE_PRIVATE)

        root = findViewById(R.id.scroll_view)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)

        textForgotPassword = findViewById(R.id.text_forgot_password)

        btCreateAccount = findViewById(R.id.bt_create_account)

        btLogin = findViewById(R.id.bt_login)



       // val isLogin = sharedPreferences!!.getBoolean(keyLogin, false)

        /*  if (isLogin) {

            goToHome()

        } else {

            getValidation()

        }*/

        btLogin.setOnClickListener {

            getValidation()

        }

        textForgotPassword.setOnClickListener {

            // startActivity(Intent(applicationContext,LostPasswordEmail::class.java))
            // finish()
            val i = Intent(applicationContext, LostPasswordEmail::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)


        }


        btCreateAccount.setOnClickListener {

            //startActivity(Intent(applicationContext,CreateAccount::class.java))
            val i = Intent(applicationContext, CreateAccount::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)

        }



    }

    private fun getValidation() {
        val email = edtEmail.text.toString()
        val password = edtPassword.text.toString()

        if (email.isNullOrEmpty()) {

            edtEmail.error = "Email is Empty"
            edtEmail.isFocusable
            onSnackBar("Email is Empty")

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Email is not valid!"
            edtEmail.isFocusable
            onSnackBar("Email is not valid!")
        } else if (password.isNullOrEmpty()) {
            edtPassword.error = "Password is Empty"
            edtPassword.isFocusable
            onSnackBar("Password is Empty")
        } else {
            //getLogin(email, password)
            goToHome()
        }
    }

   /* private fun getLogin(email: String, password: String) {

        val saveEmail = sharedPreferences!!.getString(keyEmai, "")
        val savePassword = sharedPreferences!!.getString(keyPassword, "")

        if (saveEmail != email || savePassword != password) {

            val message = "Email and Password not existing"

            onSnackBar(message)

        } else {
            val editor = sharedPreferences!!.edit()
            editor.putBoolean(keyLogin, true)
            editor.apply()

            goToHome()
        }

    }*/

    private fun onSnackBar(message: String) {
        Snackbar.make(root, message, Snackbar.LENGTH_SHORT)
            .setBackgroundTint(getColor(R.color.black_gray))
            .setTextColor(getColor(R.color.white))
            .show()
    }

    private fun goToHome() {

        val i = Intent(applicationContext, Home::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
        finish()

    }
}