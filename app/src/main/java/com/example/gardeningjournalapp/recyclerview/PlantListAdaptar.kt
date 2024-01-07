package com.example.gardeningjournalapp.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningjournalapp.databinding.PlantListBinding
import com.example.gardeningjournalapp.db.Plant


class PlantListAdaptar(private val plist: ArrayList<Plant>,private val listener : OnItemClickListener) : RecyclerView.Adapter<PlantListAdaptar.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = PlantListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val plant = plist[position]
        holder.binding.plantName.text = plant.name
        holder.itemView.setOnClickListener {
           listener.onItemClick(plant)
        }
        holder.binding.deleteIcon.setOnClickListener {
            listener.onDeleteClick(plant, position)
        }
    }

    override fun getItemCount(): Int {
        return plist.size
    }

    inner class MyViewHolder(val binding: PlantListBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onItemClick(plant: Plant)
        fun onDeleteClick(plant: Plant, position: Int)
    }
}
