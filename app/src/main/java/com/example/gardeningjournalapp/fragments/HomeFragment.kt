package com.example.gardeningjournalapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gardeningjournalapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.apply {
            gardenLogs.setOnClickListener {
                val directions = HomeFragmentDirections.actionHomeFragmentToGardenLogFragment2();
                findNavController().navigate(directions)
            }
            createPlant.setOnClickListener {
                val directions = HomeFragmentDirections.actionHomeFragmentToLogPlantFragment();
                findNavController().navigate(directions)
            }
        }

        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Home"
        return binding.root;
    }
}