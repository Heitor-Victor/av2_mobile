package com.example.exercita_recife

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.exercita_recife.R.layout

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home_screen)

        val list_button = findViewById<Button>(R.id.search_button)

        list_button.setOnClickListener {
            listScreen()
        }

    }
    fun listScreen() {
        val listScreen = Intent(this, UsersLista::class.java)
        startActivity(listScreen)
    }
}