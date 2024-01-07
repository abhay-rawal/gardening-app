package com.example.gardeningjournalapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardeningjournalapp.R
import com.example.gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.recyclerview.PlantListAdaptar
import com.example.gardeningjournalapp.viewmodel.GardenLogViewModel

class GardenLogFragment : BaseFragment(), PlantListAdaptar.OnItemClickListener {
    private lateinit var binding: FragmentGardenLogBinding
    private lateinit var viewModel: GardenLogViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =  FragmentGardenLogBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(GardenLogViewModel::class.java)

        viewModel.allPlants.observe(viewLifecycleOwner) { plants ->
            if(plants.isEmpty())
            {
                PopulatePlantDb()
            }
            binding.rv.adapter = PlantListAdaptar(plants as ArrayList<Plant>,this)
        }

        binding.apply {
            binding.rv.layoutManager = LinearLayoutManager(context)
        }
        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Garden Log";
        return binding.root;
    }

    private fun PopulatePlantDb() {
        val samplePlants = mutableListOf<Plant>()
        samplePlants.add(Plant(name = "Rose", type = "Flower", wateringFrequency = 2, plantingDate = "2023-01-01"))
        samplePlants.add(Plant(name = "Tomato", type = "Vegetable", wateringFrequency = 3, plantingDate = "2023-02-15"))
        samplePlants.add(Plant(name = "Basil", type = "Herb", wateringFrequency = 1, plantingDate = "2023-03-10"))
        for (plant in samplePlants) {
            viewModel.insert(plant)
        }
    }
    override fun onItemClick(plant: Plant) {
        val directions = GardenLogFragmentDirections.actionGardenLogFragmentToPlantDetailsFragment(plant.id)
        findNavController().navigate(directions)
    }

    override fun onDeleteClick(plant: Plant, position: Int) {
        viewModel.delete(plant) // Assuming you have a delete method in your ViewModel
        // Notify the adapter about item removed
        (binding.rv.adapter as PlantListAdaptar).notifyItemRemoved(position)
    }
}