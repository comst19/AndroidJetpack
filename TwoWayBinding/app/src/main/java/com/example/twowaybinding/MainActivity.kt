package com.example.twowaybinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.twowaybinding.databinding.ActivityMainBinding

// 양방향 데이터 결합(Two - Way Binding)
// 데이터와 뷰를 직접 연결해서 서로와 서로에게 영향을 줌
// 1. 기존 방식 -> Activity에서 View와 연결해서 사용하는 방법
// 2. 양방향 데이터 결합 방식 -> ViewModel <-> (Activity) <-> XML

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.item = viewModel
        binding.lifecycleOwner = this

//        setContentView(R.layout.activity_main)
//        // 1. 기존 방식
//        var age = 0
//
//        val ageArea = findViewById<TextView>(R.id.ageArea)
//        val plusBtn = findViewById<Button>(R.id.plusBtn)
//
//        plusBtn.setOnClickListener {
//            age++
//            ageArea.text = age.toString()
//        }
    }
}