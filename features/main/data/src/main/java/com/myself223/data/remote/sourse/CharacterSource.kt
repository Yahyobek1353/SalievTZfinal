package com.myself223.data.remote.sourse

import com.myself223.data.base.BasePagingSource
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.dto.characters.CharacterDto
import com.myself223.domain.model.CharacterModel
class CharacterSource(
    private val apiService: ApiService
) : BasePagingSource<CharacterDto, CharacterModel>(
    request = { page -> apiService.getCharacters(page) }
)
