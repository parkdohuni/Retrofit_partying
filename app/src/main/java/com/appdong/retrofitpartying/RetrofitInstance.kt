package com.appdong.retrofitpartying

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASE_URL = "https://parting.duckdns.org/dev/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : MyApi by lazy {
        retrofit.create(MyApi::class.java)
    }
}