package com.miu.gardeningjournal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.miu.gardeningjournal.databinding.FragmentPlantDetailsBinding

class PlantDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPlantDetailsBinding
    private lateinit var viewModel: GardenLogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View, savedInstanceState:
        Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // Get the plantId from the arguments
        val plantId = arguments?.getInt("pId") ?: 0
        viewModel = ViewModelProvider(this)[GardenLogViewModel::class.java]

        // Observe the plant details and update UI
        viewModel.getPlantById(plantId).observe(viewLifecycleOwner, Observer { plant ->
            plant?.let { displayPlantDetails(it) }
        })
    }

    private fun displayPlantDetails(plant: Plant) {
        // Update UI with plant details
        view?.findViewById<TextView>(R.id.textViewPlantName)?.text = plant.name
        view?.findViewById<TextView>(R.id.textViewPlantType)?.text = "Type: ${plant.type}"
        view?.findViewById<TextView>(R.id.textViewWateringFrequency)?.text = "Watering Frequency: ${plant.wateringFrequency} day(s)"
        view?.findViewById<TextView>(R.id.textViewPlantingDate)?.text = "Planting Date: ${plant.plantingDate}"
    }
}