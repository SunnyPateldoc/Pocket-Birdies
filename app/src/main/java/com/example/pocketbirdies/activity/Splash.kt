package com.example.pocketbirdies.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.pocketbirdies.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //window.statusBarColor = ContextCompat.getColor(applicationContext,R.color.black_gray)


        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(applicationContext,LoginPlayer::class.java))
            /*startActivity(
                Intent(
                    this,
                    LoginPlayer::class.java
                )
            )*/
            finish()
        }, 2000)


    }
}