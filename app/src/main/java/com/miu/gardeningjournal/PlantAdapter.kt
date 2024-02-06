package com.miu.gardeningjournal

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.gardeningjournal.databinding.ListItemPlantBinding

class PlantAdapter : ListAdapter<Plant, PlantAdapter.PlantViewHolder>(PlantDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemPlantBinding.inflate(inflater, parent, false)
        return PlantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = getItem(position)
        holder.bind(plant)
    }

    class PlantViewHolder(private val binding: ListItemPlantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(plant: Plant) {
            binding.apply {
                plantName.text = plant.name

                // Set click listener for the plant name
                plantName.setOnClickListener {
                    val plantName = "Plant Name: ${plant.name}"
                    val plantType = "Type: ${plant.type}"
                    val waterFrequency = "Watering Frequency: ${plant.wateringFrequency} day(s)"
                    val plantingDate = "Planting Date: ${plant.plantingDate}"

                    // Get the NavController from the itemView
                    val navController = it.findNavController()
                    // Navigate to the plant details destination with plant details
                    navController.navigate(GardenLogFragmentDirections.actionGardenLogToPlantDetailsFragment(plantName, plantType, waterFrequency, plantingDate))
                }
            }
        }
    }

    class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }
    }
}
