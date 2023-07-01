package com.example.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private var countValue = 0
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        Log.d("MainActivity","onCreate")

        binding.result.text = viewModel.countValue.toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.result.text = viewModel.countValue.toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.result.text = viewModel.countValue.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestory")

    }
}