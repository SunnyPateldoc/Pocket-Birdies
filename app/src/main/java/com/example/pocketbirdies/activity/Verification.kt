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

class Verification : AppCompatActivity() {
    lateinit var btVerify:TextView
    lateinit var imgBack : ImageView

    lateinit var edtCode :EditText
    lateinit var root: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)


        edtCode = findViewById(R.id.edt_code)

        imgBack = findViewById(R.id.image_back)

        btVerify = findViewById(R.id.bt_verify)

        root = findViewById(R.id.scroll_view)

        btVerify.setOnClickListener {

            //startActivity(Intent(applicationContext,ResetPassword::class.java))

            getValidestion()

        }

        imgBack.setOnClickListener {
            this.onBackPressed()
        }

    }

    private fun getValidestion() {

        val code = edtCode.text.toString()
        if (code.isNullOrEmpty()){
            edtCode.error = "Please enter Code!"
            edtCode.isFocusable
            onSnackBar("Please enter Code!")
        }else if (code.length!=4 || code != "1234"){
            edtCode.error = "Please enter valid code!"
            edtCode.isFocusable
            onSnackBar("Please enter valid code!")
        }else{
            val i = Intent(applicationContext, ResetPassword::class.java)
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