package com.example.pocketbirdies.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pocketbirdies.R


class SuccessFirst : AppCompatActivity() {
    lateinit var btLogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_first)

        btLogin = findViewById(R.id.bt_login)

        btLogin.setOnClickListener {

           // startActivity(Intent(applicationContext,LoginPlayer::class.java))
            val i = Intent(applicationContext, LoginPlayer::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
           // finish()

        }

    }


    override fun onBackPressed() {
        super.onBackPressed()
    }
}