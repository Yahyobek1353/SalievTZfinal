package com.myself223.data.remote.repository.character

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.sourse.CharacterFiltreSource
import com.myself223.data.remote.sourse.CharacterSource
import com.myself223.data.remote.sourse.SearchCharacterByNameSource
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(private val api: ApiService) : CharacterRepository {

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> =
        Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { CharacterSource(api) }
        ).flow

    override fun searchCharacterByName(name: String): Flow<PagingData<CharacterModel>> =
        Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { SearchCharacterByNameSource(api, name) }
        ).flow


    override fun filterCharacters(
        status: String?,
        species: String?,
        gender: String?
    ): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                CharacterFiltreSource(api, status, species, gender)
            }
        ).flow


    }
}
