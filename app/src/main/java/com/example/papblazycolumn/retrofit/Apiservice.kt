package com.example.papblazycolumn.retrofit

import com.example.papblazycolumn.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
