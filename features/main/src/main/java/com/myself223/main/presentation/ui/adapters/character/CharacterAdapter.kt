package com.myself223.main.presentation.ui.adapters.character

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myself223.core.loadImageURL
import com.myself223.main.databinding.ItemCharactersBinding
import com.myself223.main.presentation.model.CharacterUi

class CharacterAdapter :
    PagingDataAdapter<CharacterUi, CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.onBind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
}

class CharacterViewHolder(private val binding: ItemCharactersBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(character: CharacterUi) {
        binding.itemTvCharacterName.text = character.name
        binding.itemTvGender.text = character.gender
        binding.itemTvStatus.text = character.status
        binding.itemTvType.text = character.species
        binding.itemImgCharacter.loadImageURL(character.image)
        when (character.status) {
            "Alive" -> binding.itemStatusColor.setBackgroundColor(Color.GREEN)
            "Dead" -> binding.itemStatusColor.setBackgroundColor(Color.RED)
            "unknown" -> binding.itemStatusColor.setBackgroundColor(Color.GRAY)
        }
    }
}

class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterUi>() {
    override fun areItemsTheSame(oldItem: CharacterUi, newItem: CharacterUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterUi, newItem: CharacterUi): Boolean {
        return oldItem == newItem
    }
}
