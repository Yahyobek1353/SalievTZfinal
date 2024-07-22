package com.myself223.main.presentation.ui.adapters.episodes

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myself223.core.loadImageURL
import com.myself223.main.databinding.ItemCharactersBinding
import com.myself223.main.databinding.ItemEpisodesBinding
import com.myself223.main.presentation.model.CharacterUi
import com.myself223.main.presentation.model.EpisodesUi

class EpisodesAdapter :
    PagingDataAdapter<EpisodesUi, EpisodesViewHolder>(EpisodesDiffCallback()) {

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.onBind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EpisodesViewHolder(
        ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

class EpisodesViewHolder(private val binding: ItemEpisodesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(episodes: EpisodesUi) {
        binding.itemTvEpisodeName.text = episodes.name
        binding.itemTvAirDate.text  = episodes.date
        binding.itemTvEpisodeCode.text  = episodes.episode
    }

}

class EpisodesDiffCallback : DiffUtil.ItemCallback<EpisodesUi>() {
    override fun areItemsTheSame(oldItem: EpisodesUi, newItem: EpisodesUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EpisodesUi, newItem: EpisodesUi): Boolean {
        return oldItem == newItem
    }

}