package com.example.papblazycolumn.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Users {
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
