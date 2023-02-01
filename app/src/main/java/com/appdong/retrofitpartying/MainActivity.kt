package com.appdong.retrofitpartying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.appdong.retrofitpartying.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    /* View */
    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            if (it.isSuccessful){
                Log.d("Response", it.body()?.categoryName.toString()+"!!!!!!!!!!!!!!!!!!!!!!")
                binding.categoryName.text = it.body()?.categoryName.toString()
            }
            else{
                Log.d("Fail","Fail!!!!!")
            }
        })
    }
}
//
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController

//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//        api.getPost().enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                name = response.body() as String
//                binding.categoryName.text = name
//                println("$name!!!!!!!!!!!!!!!!!!")
//                Log.d("MAIN", response.toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("MAIN", t.toString())
//            }
//        })
//
//        api.getPost2(2).enqueue(object : Callback<Post> {
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("MAIN2", response.toString())
//                println()
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("MAIN2", t.toString())
//            }
//        })
//    }
//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        viewModel.result.observe(this, Observer {
//            binding.categoryName.text = it
//        })
//
//        viewModel.result.observe(this, Observer {
//            Log.d("MAIN", it)
//        })
//    }