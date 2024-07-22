package com.myself223.domain.usecase

import androidx.paging.PagingData
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.model.EpisodesModel
import com.myself223.domain.repository.episodes.EpisodesRepository
import kotlinx.coroutines.flow.Flow

class SearchEpisodesUseCase(private val repository: EpisodesRepository) {

    fun searchEpisodesByName(name: String): Flow<PagingData<EpisodesModel>> {
        return repository.searchEpisodesByName(name)
    }
}
