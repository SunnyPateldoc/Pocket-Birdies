package com.example.pocketbirdies.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import com.example.pocketbirdies.R
import com.google.android.material.snackbar.Snackbar

class ResetPassword : AppCompatActivity() {

    lateinit var btResetPassword : TextView

    lateinit var imgBack : ImageView

    lateinit var edtNewPassword :EditText
    lateinit var edtConfirmPassword :EditText
    lateinit var root: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        btResetPassword=findViewById(R.id.bt_reset_password)
        imgBack = findViewById(R.id.image_back)

        edtNewPassword = findViewById(R.id.edt_new_password)
        edtConfirmPassword = findViewById(R.id.edt_confirm_password)

        root = findViewById(R.id.scroll_view)

        imgBack.setOnClickListener {

            this.onBackPressed()

        }

        btResetPassword.setOnClickListener {

            //startActivity(Intent(applicationContext,SuccessFirst::class.java))

            getValidetion()

        }
    }

    private fun getValidetion() {

        val newPassword = edtNewPassword.text.toString()
        val confirmPassword = edtConfirmPassword.text.toString()

        if (newPassword.isNullOrEmpty()){
            edtNewPassword.error = "Password is empty!"
            edtNewPassword.isFocusable
            onSnackBar("Password is empty!")
        }else if (newPassword.length < 8){
            edtNewPassword.error = "Password must be 8 !"
            edtNewPassword.isFocusable
            onSnackBar("Password must be 8!")
        }else if (confirmPassword.isNullOrEmpty()){
            edtConfirmPassword.error = "Confirm Password is empty!"
            edtConfirmPassword.isFocusable
            onSnackBar("Confirm Password is empty!")
        }else if (confirmPassword != newPassword){
            edtNewPassword.error = "Password dose not matche!"
            edtNewPassword.isFocusable
            edtConfirmPassword.error = "Password dose not matche!"
            edtConfirmPassword.isFocusable
            onSnackBar("Password dose not matche!")
        }else{
            val i = Intent(applicationContext, SuccessFirst::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
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