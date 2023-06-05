package com.example.pocketbirdies.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pocketbirdies.R

class SuccessSecond : AppCompatActivity() {

    lateinit var btLogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_second)

        btLogin = findViewById(R.id.bt_login)

        btLogin.setOnClickListener {

            val i = Intent(applicationContext, LoginPlayer::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)

        }


    }
}