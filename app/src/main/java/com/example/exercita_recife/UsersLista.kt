package com.example.exercita_recife

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercita_recife.adapter.AdapterUsers
import com.example.exercita_recife.databinding.ActivityUsersListaBinding

class UsersLista : AppCompatActivity() {

    private lateinit var binding: ActivityUsersListaBinding
    private lateinit var adapterUsers: AdapterUsers
    var ListaUsuarios = arrayListOf<UsersClass>()
    fun usarArray(): ArrayList<UsersClass> {
        val myInstance = RegisterScreen()
        val array = myInstance.usersList
        return array
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityUsersListaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerViewUsers = binding.recyclerViewUsers
        recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        recyclerViewUsers.setHasFixedSize(true)
        ListaUsuarios = usarArray()
        adapterUsers = AdapterUsers(this,ListaUsuarios)
        recyclerViewUsers.adapter = adapterUsers

    }
}