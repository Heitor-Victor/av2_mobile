package com.example.exercita_recife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_successful)

        val return_button = findViewById<Button>(R.id.return_button)

        return_button.setOnClickListener {
            returnLogin()
        }
    }
    fun returnLogin() {
        val returnLogin = Intent(this,MainActivity::class.java)
        startActivity(returnLogin)
    }
}