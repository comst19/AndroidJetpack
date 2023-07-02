package com.example.roomflowlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomflowlistadapter.databinding.ActivityNextBinding
import com.example.roomflowlistadapter.db.MyDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NextActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNextBinding
    private lateinit var db : MyDatabase
    private val adapter = MyListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MyDatabase.getDatabase(this)

        binding.userRV.adapter = adapter
        binding.userRV.layoutManager = LinearLayoutManager(this)

        binding.read.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().getAllDataWithFlow().collect {
                    withContext(Dispatchers.Main) {
                        adapter.submitList(it)
                    }
                }
            }
        }

        binding.update.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDao().getAllData()
                val userEntity = result[id]
                userEntity.name = "updated 된 id"

                db.userDao().update(userEntity)
            }
        }

        binding.delete.setOnClickListener {

            val id = binding.id.text.toString().toInt()

            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDao().getAllData()
                val userEntity = result[id]

                db.userDao().delete(userEntity)
            }
        }
    }
}