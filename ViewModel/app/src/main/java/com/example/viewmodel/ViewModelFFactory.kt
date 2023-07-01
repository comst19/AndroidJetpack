package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFFactory(private val num : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ViewModelFF::class.java)){
            return ViewModelFF(num) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}