package com.appdong.retrofitpartying

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("categoryName")
    val categoryName: String
)
