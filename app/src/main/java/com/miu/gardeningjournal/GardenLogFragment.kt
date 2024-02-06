package com.miu.gardeningjournal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.gardeningjournal.databinding.FragmentGardenLogBinding
import kotlinx.coroutines.launch

class GardenLogFragment : Fragment() {

    private lateinit var binding: FragmentGardenLogBinding
    private lateinit var viewModel: GardenLogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[GardenLogViewModel::class.java]
        binding = FragmentGardenLogBinding.inflate(
            inflater, container,
            false
        )
//        binding.apply {
//            plantDetailsBtn.setOnClickListener {
//                val directions = GardenLogFragmentDirections.actionGardenLogToPlantDetailsFragment()
//                findNavController().navigate(directions)
//            }
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.plantsRecycleView)
        val adapter = PlantAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.allPlants.observe(viewLifecycleOwner) { plants ->
            plants?.let { adapter.submitList(it) }
        }

        val samplePlants = mutableListOf<Plant>()
        // Add sample plants
        samplePlants.add(Plant(name = "Rose", type = "Flower", wateringFrequency = 2, plantingDate = "2023-01-01"))
        samplePlants.add(Plant(name = "Tomato", type = "Vegetable", wateringFrequency = 3, plantingDate = "2023-02-15"))
        samplePlants.add(Plant(name = "Basil", type = "Herb", wateringFrequency = 1, plantingDate = "2023-03-10"))

        // Insert sample plants into the database if empty
        if(viewModel.allPlants.value?.isEmpty() == true) {
            for (plant in samplePlants) {
                viewModel.insert(plant)
            }
        }
        view.findViewById<Button>(R.id.btnAddPlant).setOnClickListener {
            val newPlant = Plant( name="Mango", type =  "Fruit", wateringFrequency =  2, plantingDate = "2024-02-06")
            lifecycleScope.launch {
              viewModel.insert(newPlant)
            }
        }
    }
}