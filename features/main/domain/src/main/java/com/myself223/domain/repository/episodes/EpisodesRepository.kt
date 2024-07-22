package com.myself223.domain.repository.episodes

import androidx.paging.PagingData
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.model.EpisodesModel
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {
    fun getAllEpisodes(): Flow<PagingData<EpisodesModel>>
    fun searchEpisodesByName(name: String): Flow<PagingData<EpisodesModel>>

}