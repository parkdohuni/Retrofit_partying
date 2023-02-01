package com.appdong.retrofitpartying

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository : Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
//    private val repository = Repository()
//
//    private var _result = MutableLiveData<String>()
//    val result: LiveData<String>
//        get() = _result

    fun getPost() = viewModelScope.launch {
        val response = repository.getPost()
        myResponse.value = response
//        Log.d("getName",repository.getAllData().toString())
//        _result.value = repository.getAllData().toString()
    }

//    fun getPost1(){
//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//        api.getPost(
//
//        ).enqueue(object : Callback<Post> {
//
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                _result.value = response.toString()
//                println(_result.value+"!!!!!!!!!!!!!!!!!!!!")
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("FAIL", "FAIL")
//            }
//        })
//    }

}