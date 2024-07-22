package com.myself223.domain.usecase

import androidx.paging.PagingData
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class SearchCharacterUseCase(private val repository: CharacterRepository) {

    fun searchCharacterByName(name: String): Flow<PagingData<CharacterModel>> {
        return repository.searchCharacterByName(name)
    }
}
