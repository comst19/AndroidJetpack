package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class ViewModelFactoryActivity : AppCompatActivity() {

    lateinit var viewModel : ViewModelFF
    lateinit var viewModelFactory : ViewModelFFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_factory)

        viewModelFactory = ViewModelFFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelFF::class.java)
    }
}