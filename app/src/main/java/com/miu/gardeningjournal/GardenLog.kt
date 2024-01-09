package com.miu.gardeningjournal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miu.gardeningjournal.databinding.FragmentGardenLogBinding

class GardenLog : Fragment() {

    private lateinit var binding: FragmentGardenLogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGardenLogBinding.inflate(
            inflater, container,
            false
        )

        binding.apply {
            plantDetailsBtn.setOnClickListener {
                val directions = GardenLogDirections.actionGardenLogToPlantDetailsFragment()
                findNavController().navigate(directions)
            }
        }

        return binding.root
    }
}