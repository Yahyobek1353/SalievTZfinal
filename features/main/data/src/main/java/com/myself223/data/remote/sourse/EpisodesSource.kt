package com.myself223.data.remote.sourse

import com.myself223.data.base.BasePagingSource
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.dto.characters.CharacterDto
import com.myself223.data.remote.dto.episodes.EpisodesDto
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.model.EpisodesModel

class EpisodesSource(
    private val apiService: ApiService
): BasePagingSource<EpisodesDto,EpisodesModel>({ page ->
    apiService.getEpisodes(
        page = page
    )
})