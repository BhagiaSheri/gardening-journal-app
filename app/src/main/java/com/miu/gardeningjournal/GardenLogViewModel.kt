package com.miu.gardeningjournal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GardenLogViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PlantRepository
    val allPlants: LiveData<List<Plant>>

    init {
        repository = PlantRepository(application)
        allPlants = repository.allPlants
    }

    fun insert(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
    }

    fun update(plant: Plant) = viewModelScope.launch {
        repository.update(plant)
    }

    fun delete(plant: Plant) = viewModelScope.launch {
        repository.delete(plant)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun getPlantById(plantId: Int): LiveData<Plant> {
        return repository.getPlantById(plantId)
    }
}
