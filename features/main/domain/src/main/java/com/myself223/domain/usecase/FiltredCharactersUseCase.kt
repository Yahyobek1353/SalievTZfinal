package com.myself223.domain.usecase

import androidx.paging.PagingData
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class   FiltredCharactersUseCase(private val repository: CharacterRepository) {
    fun filter(status: String?, species: String?, gender: String?): Flow<PagingData<CharacterModel>> {
        return repository.filterCharacters(status, species, gender)
    }
}