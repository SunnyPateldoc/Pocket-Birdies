package com.example.pocketbirdies.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.pocketbirdies.R

class CreateAccount : AppCompatActivity() {
    lateinit var btCreateAccount: TextView
    lateinit var btGolfer:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        btCreateAccount = findViewById(R.id.bt_create_account)
        btGolfer = findViewById(R.id.bt_golfer)

        btGolfer.setOnClickListener {

            btCreateAccount.visibility = View.VISIBLE

        }

        btCreateAccount.setOnClickListener {

           // startActivity(Intent(applicationContext,CreateAccountGolferFirst::class.java))
            val i = Intent(applicationContext, CreateAccountGolferFirst::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)

        }

    }
}