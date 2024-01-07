package com.example.gardeningjournalapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.db.PlantDatabase
import com.example.gardeningjournalapp.db.PlantRepository
import kotlinx.coroutines.launch

class GardenLogViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PlantRepository

    val allPlants: LiveData<List<Plant>>

    init {
        val plantDao = PlantDatabase.getDatabase(application).plantDao()
        repository = PlantRepository(application)
        allPlants = repository.allPlants
    }

    fun insert(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
    }

    fun update(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
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
