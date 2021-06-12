package com.example.restoapp

import android.R.id.message
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvDetailName: TextView
    private lateinit var tvDetailCity: TextView
    private lateinit var detailImage: ImageView
    private lateinit var rvMenu : RecyclerView
    private var foods: Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.statusBarColor = Color.TRANSPARENT

        setContentView(R.layout.activity_detail)


        rvMenu = findViewById(R.id.rv_menu)
        tvDetailName = findViewById(R.id.tv_detail_name)
        tvDetailCity = findViewById(R.id.tv_detail_city)
        detailImage = findViewById(R.id.detail_image_resto)


        val bundle = intent.extras
        val dataMenuFoods = bundle?.getStringArray("menuFoods") ?: arrayOf()
        val dataName = bundle?.getString("restoName")
        val dataCity = bundle?.getString("restoCity")
        val dataImage = bundle?.getInt("restoImage") ?: 0

        tvDetailName.text = dataName
        tvDetailCity.text = dataCity
        detailImage.setImageResource(dataImage)

        foods = dataMenuFoods
        showListMenu()

        val btnBackToHome: ImageButton = findViewById(R.id.imgBtn_detailBackToHome)
        btnBackToHome.setOnClickListener(this)

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            sendMessage(dataName,dataCity)
        }
    }

    private fun sendMessage(dataName: String?, dataCity: String?) {
        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"
        intent.setPackage("com.whatsapp")

        // Give your message here
        intent.putExtra(Intent.EXTRA_TEXT,"Resto Bagus nih , namanya ${dataName} ada di ${dataCity}")

        // Checking whether Whatsapp
        // is installed or not
        if (intent.resolveActivity(packageManager) == null) {
            Toast.makeText(this,"Please install whatsapp first.",Toast.LENGTH_SHORT).show()
            return
        }
        startActivity(intent)
    }

    private fun showListMenu() {
        rvMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val listMenuAdapter = ListMenuAdapter(foods)
        rvMenu.adapter = listMenuAdapter
    }

    override fun onClick(v: View?) {
        val backHomeIntent = Intent(this, MainActivity::class.java)
        startActivity(backHomeIntent)
    }
}