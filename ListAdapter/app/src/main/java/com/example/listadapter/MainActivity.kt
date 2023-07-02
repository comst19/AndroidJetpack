package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapter.databinding.ActivityMainBinding

// DiffUtil / ListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val adapter = CatListAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.catRV.adapter = adapter
        binding.catRV.layoutManager = LinearLayoutManager(this)

        adapter.submitList(firstSetupData())

        Handler(Looper.getMainLooper()).postDelayed({
            adapter.submitList(secondSetupData())
        }, 3000)
    }

    fun firstSetupData() : ArrayList<CatDataModel>{
        val cat1 = CatDataModel(1, "cat1", 10)
        val cat2 = CatDataModel(2, "cat2", 11)
        val cat3 = CatDataModel(3, "cat3", 12)
        val cat4 = CatDataModel(4, "cat4", 13)
        val cat5 = CatDataModel(5, "cat5", 14)

        val arr1 = ArrayList<CatDataModel>()
        arr1.add(cat1)
        arr1.add(cat2)
        arr1.add(cat3)
        arr1.add(cat4)
        arr1.add(cat5)

        return arr1
    }

    fun secondSetupData() : ArrayList<CatDataModel>{
        val cat3 = CatDataModel(3, "cat3", 12)
        val cat4 = CatDataModel(4, "cat4", 13)
        val cat5 = CatDataModel(5, "cat5", 14)
        val cat6 = CatDataModel(6, "cat6", 15)
        val cat7 = CatDataModel(7, "cat7", 16)
        val cat8 = CatDataModel(8, "cat8", 17)

        val arr2 = ArrayList<CatDataModel>()
        arr2.add(cat3)
        arr2.add(cat4)
        arr2.add(cat5)
        arr2.add(cat6)
        arr2.add(cat7)
        arr2.add(cat8)
        return arr2

    }
}