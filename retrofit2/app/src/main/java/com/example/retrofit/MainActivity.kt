package com.example.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materi.model.Data
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.databinding.ItemUsersBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterUser = UsersAdapter()
        with(binding){
            rvUser.apply {
                adapter = adapterUser
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}