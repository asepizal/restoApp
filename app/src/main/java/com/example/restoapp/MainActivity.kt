package com.example.restoapp

import alzaichsank.com.intentanimation.AnimIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    // inisialisasi recycler view
    private lateinit var rvResto : RecyclerView
    private var list: ArrayList<Resto> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        rvResto = findViewById(R.id.rv_resto)
        rvResto.setHasFixedSize(true)

        list.addAll(RestoData.listData)
        showRecyclerCardView()

    }

    private fun showRecyclerCardView() {
        rvResto.layoutManager = LinearLayoutManager(this)
        val cardViewRestoAdapter = CardViewRestoAdapter(list)
        rvResto.adapter = cardViewRestoAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val menuItem = menu?.findItem(R.id.menu_profile)
        val view = MenuItemCompat.getActionView(menuItem)

        val profileImage = view.findViewById<CircleImageView>(R.id.toolbar_profile_image)

        profileImage.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(moveIntent)
            AnimIntent.Builder(this).performSlideToLeft()
        }
        return super.onCreateOptionsMenu(menu)
    }


}