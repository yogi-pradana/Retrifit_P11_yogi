package com.example.materi.network

import com.example.materi.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")
    fun getAllUsers(): Call<Users>
}