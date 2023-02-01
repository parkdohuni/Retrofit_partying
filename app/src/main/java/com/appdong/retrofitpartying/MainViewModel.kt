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


    fun getPost() = viewModelScope.launch {
        val response = repository.getPost()
        myResponse.value = response

    }


}