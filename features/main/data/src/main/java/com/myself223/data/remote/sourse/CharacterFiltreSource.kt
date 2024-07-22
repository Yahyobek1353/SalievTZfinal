package com.myself223.data.remote.sourse

import com.myself223.domain.model.CharacterModel
import com.myself223.data.base.BasePagingSource
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.dto.characters.CharacterDto

class CharacterFiltreSource(
    private val apiService: ApiService,
    private val status: String?,
    private val species: String?,
    private val gender: String?
) : BasePagingSource<CharacterDto, CharacterModel>(
    request = { position ->
        apiService.getCharacters(
            page = position,
            status = status,
            species = species,
            gender = gender
        )
    }
)
