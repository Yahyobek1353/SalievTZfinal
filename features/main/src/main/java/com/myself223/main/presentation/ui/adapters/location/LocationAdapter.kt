package com.myself223.main.presentation.ui.adapters.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myself223.main.databinding.ItemLocationBinding
import com.myself223.main.presentation.model.LocationUi

class LocationAdapter :
    PagingDataAdapter<LocationUi, LocationViewHolder>(LocationDiffCallback()) {

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.onBind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LocationViewHolder(
        ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

class LocationViewHolder(private val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(location: LocationUi) {
        binding.itemTvPlanetName.text = location.name
        binding.itemTvPlanetType.text = location.type
        binding.itemTvPlanetDimension.text = location.dimension
    }

}

class LocationDiffCallback : DiffUtil.ItemCallback<LocationUi>() {
    override fun areItemsTheSame(oldItem: LocationUi, newItem: LocationUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LocationUi, newItem: LocationUi): Boolean {
        return oldItem == newItem
    }

}