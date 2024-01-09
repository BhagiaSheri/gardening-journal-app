package com.miu.gardeningjournal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miu.gardeningjournal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(
            inflater, container,
            false
        )

        binding.apply {
            gardenLogBtn.setOnClickListener {
                val directions = HomeFragmentDirections.actionHomeFragmentToGardenLog()
                findNavController().navigate(directions)
            }
        }

        return binding.root
    }
}