package com.example.twowaybinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var mutableAge = MutableLiveData(0)

    fun plus(){
        mutableAge.value = mutableAge.value?.plus(1)
    }
}