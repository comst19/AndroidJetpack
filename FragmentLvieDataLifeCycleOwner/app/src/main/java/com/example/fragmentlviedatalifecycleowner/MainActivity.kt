package com.example.fragmentlviedatalifecycleowner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentlviedatalifecycleowner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val transaction1 = manager.beginTransaction()
            val fragment1 = BlankFragment1()
            transaction1.replace(R.id.frameArea, fragment1)
            transaction1.addToBackStack(null)
            transaction1.commit()
        }

        binding.btn2.setOnClickListener {
            val transaction2 = manager.beginTransaction()
            val fragment2 = BlankFragment2()
            transaction2.replace(R.id.frameArea, fragment2)
            transaction2.addToBackStack(null)
            transaction2.commit()
        }
    }
}