package com.example.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.viewmodel.databinding.FragmentShareBinding

class ShareFragment : Fragment() {

    private var _binding : FragmentShareBinding? = null
    private val binding get() = _binding!!
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShareBinding.inflate(inflater, container, false)

        binding.sharedFragmentText.text = viewModel.getCount().toString()
        return binding.root
    }
}