package com.example.viewmodel

import androidx.lifecycle.ViewModel

// ViewModel에서 저렇게 사용하지 않고 LiveData(등등)을 이요해서 슴
// 그냥 예제일뿐

class MainViewModel : ViewModel(){

    var countValue = 0

    fun plus(){
        countValue++
    }

    fun minus(){
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }
}