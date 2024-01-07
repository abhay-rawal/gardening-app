package com.example.gardeningjournalapp.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.gardeningjournalapp.databinding.FragmentLogPlantBinding
import com.example.gardeningjournalapp.db.Plant
import com.example.gardeningjournalapp.viewmodel.GardenLogViewModel
import java.util.Calendar

class LogPlantFragment : Fragment() {
    private lateinit var binding: FragmentLogPlantBinding
    private var selectedDateString: String = ""
    private lateinit var viewModel: GardenLogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(GardenLogViewModel::class.java)
        binding = FragmentLogPlantBinding.inflate(inflater, container, false)
        binding.apply {
            btnSelectDate.setOnClickListener {
                showDatePickerDialog()
            }

            btnSave.setOnClickListener {
                // Capture the values when the button is clicked
                val plantName = etPlantName.text.toString()
                val plantType = etPlantType.text.toString()
                val plantWateringFrequency = etWateringFrequency.text.toString()
                val plantDate = selectedDateString

                // Check if the fields are not empty
                if (plantName.isNotEmpty() && plantType.isNotEmpty() && plantWateringFrequency.isNotEmpty() && plantDate.isNotEmpty()) {
                    val plant = Plant(name = plantName, type = plantType, wateringFrequency = 1, plantingDate = plantDate)
                    viewModel.insert(plant)
                    findNavController().popBackStack()
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }

            btnCancel.setOnClickListener {
                findNavController().popBackStack()
            }
        }
        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Log a new plant";
        return binding.root
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            // Format the date and store it in selectedDateString
            selectedDateString = "${selectedDay}/${selectedMonth + 1}/$selectedYear"

            // Update the TextView with the selected date
            binding.tvSelectedDate.text = selectedDateString
        }, year, month, day)

        dpd.show()
    }
}
