package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var testMutableLiveData = MutableLiveData(0)
    private lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btn.setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testLiveData.observe(this, Observer {
            binding.textArea.text = it.toString()
        })

//        viewModel.testMutableLiveData.observe(this, Observer {
//            //binding.textArea.text = viewModel.testMutableLiveData.value.toString()
//            binding.textArea.text = it.toString()
//        })

        // LiveData는 불가능, MutableLiveData는 가능
        // viewModel.testLiveData.value = 10
    }
}