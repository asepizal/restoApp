package com.example.restoapp

import alzaichsank.com.intentanimation.AnimIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btnBackToHome: ImageButton  = findViewById(R.id.imgBtn_backToHome)
        btnBackToHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val backHomeIntent = Intent(this, MainActivity::class.java)
        startActivity(backHomeIntent)
        AnimIntent.Builder(this).performSlideToRight()
    }
}