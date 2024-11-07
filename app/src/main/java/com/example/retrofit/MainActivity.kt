package com.example.retrofit


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materi.model.Data
import com.example.materi.model.Users
import com.example.materi.network.ApiClient
import com.example.retrofit.UsersAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterUser: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        fetchDataFromApi()
    }

    private fun setupRecyclerView() {
        adapterUser = UsersAdapter(emptyList()) { user ->
            Toast.makeText(this, "Clicked on ${user.first_name}", Toast.LENGTH_SHORT).show()
        }
        binding.rvUser.apply {
            adapter = adapterUser
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun fetchDataFromApi() {
        val client = ApiClient.getInstance().getAllUsers()
        client.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    val userList = response.body()?.data ?: emptyList()
                    adapterUser = UsersAdapter(userList) { user ->
                        Toast.makeText(this@MainActivity, "Clicked on ${user.first_name}", Toast.LENGTH_SHORT).show()
                    }
                    binding.rvUser.adapter = adapterUser
                } else {
                    Toast.makeText(this@MainActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
