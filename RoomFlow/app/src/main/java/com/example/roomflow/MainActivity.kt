package com.example.roomflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomflow.databinding.ActivityMainBinding
import com.example.roomflow.db.TextDatabase
import com.example.roomflow.db.TextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// 1. Flow를 사용하지 않을 때
// 2. Flow를 사용했을 때

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDatabase.getDatabase(this)

        binding.insert.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val text = TextEntity(0, binding.textInputArea.text.toString())
                db.textDao().insert(text)
                binding.textInputArea.setText("")
            }
        }

//        binding.getData.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                val resultText = db.textDao().getAllData().toString()
//
//                withContext(Dispatchers.Main){
//                    binding.resultArea.text = resultText
//                }
//
//            }
//        }

        CoroutineScope(Dispatchers.IO).launch{
            db.textDao().getAllDataFlow().collect{
                val resultText = it.toString()
                withContext(Dispatchers.Main){
                    binding.resultArea.text = resultText
                }
            }
        }

        binding.delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
            }
        }

        binding.next.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }
    }
}