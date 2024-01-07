package com.example.gardeningjournalapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.gardeningjournalapp.databinding.FragmentPlantDetailsBinding
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.viewmodel.GardenLogViewModel

class PlantDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPlantDetailsBinding
    private val navargas : PlantDetailsFragmentArgs by navArgs()

    private lateinit var viewModel: GardenLogViewModel
    private var plantId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        binding =  FragmentPlantDetailsBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Plant Details";
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plantId = navargas.plantId

        viewModel = ViewModelProvider(this).get(GardenLogViewModel::class.java)
        viewModel.getPlantById(plantId).observe(viewLifecycleOwner) { plant ->
            plant?.let { displayPlantDetails(it) }
        }
    }

    private fun displayPlantDetails(it: Plant) {
        binding.apply {
            plantName.text = it.name
            plantType.text = it.type
            plantWateringFrequency.text = it.wateringFrequency.toString()
            plantPlantingDate.text = it.plantingDate
        }
    }
}