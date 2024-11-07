package com.example.retrofit


import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.materi.model.Data
import com.example.retrofit.databinding.ItemUsersBinding

typealias OnClickDisaster = (ContactsContract.Contacts.Data) -> Unit

class UsersAdapter(
    private val listUsers: List<ContactsContract.Contacts.Data>,
    private val onClickUser: (ContactsContract.Contacts.Data) -> Unit
) : RecyclerView.Adapter<UsersAdapter.ItemUsersViewHolder>() {

    inner class ItemUsersViewHolder(private val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: ContactsContract.Contacts.Data) {
            with(binding) {
                txtName.text = "${user.first_name} ${user.last_name}"
                txtEmail.text = user.email
                // Load avatar image using Glide or other library
                Glide.with(imgPlaceholder.context).load(user.profileImage).into(imgPlaceholder)

                root.setOnClickListener { onClickUser(user) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemUsersViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemUsersViewHolder(binding)
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: ItemUsersViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }
}
