package com.example.exercita_recife.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercita_recife.UsersClass
import com.example.exercita_recife.databinding.UserItemBinding

class AdapterUsers(private val context: Context, private val listaUsuarios: ArrayList<UsersClass>): RecyclerView.Adapter<AdapterUsers.UsersViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val itemLista = UserItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return UsersViewHolder(itemLista)

    }

    override fun getItemCount() = listaUsuarios.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.txtUser.text = listaUsuarios.get(position).email
    }

    inner class UsersViewHolder(binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        val txtUser = binding.txtUser


    }
}