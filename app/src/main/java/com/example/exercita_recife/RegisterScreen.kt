package com.example.exercita_recife

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.exercita_recife.databinding.ActivityRegisterScreenBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class RegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterScreenBinding
    private lateinit var dbRef: DatabaseReference
    private val auth = FirebaseAuth.getInstance()
    val usersList: ArrayList<UsersClass> = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val register_button = findViewById<Button>(R.id.register_button2)

        register_button.setOnClickListener {View ->
            val email = binding.registerEmail.text.toString()
            val senha = binding.registerPassword.text.toString()
            val nome = binding.registerName.text.toString()
            val apelido = binding.registerLogin.text.toString()

            if (email.isEmpty() || senha.isEmpty() || nome.isEmpty()) {
                val snackbar = Snackbar.make(View , "Preencha todos os campos!", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.BLUE)
                snackbar.show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful) {
                        val user = UsersClass(email, senha, nome, apelido)
                        usersList.add(user)
                        registerSuccessful()
                    }
                }.addOnFailureListener{
                    val snackbar = Snackbar.make(View, "Ocorreu um erro!", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.BLUE)
                    snackbar.show()
                }
            }
        }
        binding.returnButton2.setOnClickListener {
            returnLogin()
        }

    }



    fun registerSuccessful() {
        val registerSuccessful = Intent(this,RegisterSuccessful::class.java)
        startActivity(registerSuccessful)
    }
    fun returnLogin() {
        val returnLogin = Intent(this,MainActivity::class.java)
        startActivity(returnLogin)
    }


}