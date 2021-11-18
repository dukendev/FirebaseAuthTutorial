package com.ysanjeet535.firebaseauthtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {
            val intent : Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        },1500)
    }
}