package com.appdong.retrofitpartying

import retrofit2.Call
import retrofit2.Response

class Repository {

    suspend fun getPost() : Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}
//MVVM 패턴을 위해 데이터 통신을 하는 Repository를 생성해준다.
