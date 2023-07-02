package com.example.roomflowlistadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomflowlistadapter.databinding.ActivityMainBinding
import com.example.roomflowlistadapter.db.MyDatabase
import com.example.roomflowlistadapter.db.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var db : MyDatabase
    private val adapter = MyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MyDatabase.getDatabase(this)

        binding.userRV.adapter = adapter
        binding.userRV.layoutManager = LinearLayoutManager(this)

        binding.next.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

        binding.save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val name = binding.name.text.toString()
                val age = binding.age.text.toString()

                val user = UserEntity(0, name, age.toInt())
                db.userDao().insert(user)
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            db.userDao().getAllDataWithFlow().collect{
                withContext(Dispatchers.Main){
                    adapter.submitList(it)
                }
            }
        }

//        binding.get.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                db.userDao().getAllDataWithFlow().collect{
//                    withContext(Dispatchers.Main){
//                        adapter.submitList(it)
//                    }
//                }
//            }
//        }
    }
}