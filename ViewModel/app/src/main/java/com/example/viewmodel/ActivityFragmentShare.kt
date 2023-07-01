package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityFragmentShareBinding

class ActivityFragmentShare : AppCompatActivity() {

    private lateinit var binding : ActivityFragmentShareBinding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.result.text = viewModel.countValue.toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.result.text = viewModel.countValue.toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.result.text = viewModel.countValue.toString()
        }

        val manager = supportFragmentManager

        binding.show.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = ShareFragment()
            transaction.replace(R.id.frame, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}