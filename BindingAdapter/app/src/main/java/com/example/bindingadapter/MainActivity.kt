package com.example.bindingadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bindingadapter.databinding.ActivityMainBinding

// 양방향 데이터 결합
// BindingAdapter -> View에 속성을 내 맘대로 수정

// 1. 기존에 양방향 데이터 결합 / BindingAdapter 사용하지 않고 제작
// 2. 양방향 데이터 결합 / BindingAdapter를 사용해서 제작

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.vm = viewModel
        binding.lifecycleOwner = this

//        // 1. 방법
//        var age = 0
//
//        binding.plus.setOnClickListener {
//            age++
//            binding.ageArea.text = age.toString()
//            if(age > 20){
//                binding.imageArea.setImageResource(R.drawable.android)
//            }
//        }
    }
}