package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodel.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            val transaction = manager.beginTransaction()
            val fragment = MainFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}