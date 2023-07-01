package com.example.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("MainFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("MainFragment", "onCreateView")
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.result.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.result.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.result.text = viewModel.getCount().toString()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainFragment", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MainFragment", "onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainFragment", "onDestory")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("MainFragment", "onDetach")
    }
}