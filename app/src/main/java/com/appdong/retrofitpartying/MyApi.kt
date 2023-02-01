package com.appdong.retrofitpartying

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {
    @GET("api/party/1")
    suspend fun getPost() : Response<Post>

    @GET("posts/{number}")
    fun getPost2(
        @Path("number") number : Int
    ) : Call<Post>
}