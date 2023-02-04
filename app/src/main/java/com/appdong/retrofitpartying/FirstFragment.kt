package com.appdong.retrofitpartying

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.appdong.retrofitpartying.databinding.FirstFragmentBinding

class FirstFragment: Fragment() {

    private lateinit var binding: FirstFragmentBinding
    private lateinit var navController: NavController
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.getData.setOnClickListener {

            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            viewModel.getPost()
            viewModel.myResponse.observe(viewLifecycleOwner, Observer {
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
}