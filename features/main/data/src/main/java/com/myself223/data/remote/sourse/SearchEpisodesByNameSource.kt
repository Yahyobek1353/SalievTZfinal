package com.myself223.data.remote.sourse

import com.myself223.data.base.BasePagingSource
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.dto.episodes.EpisodesDto
import com.myself223.domain.model.EpisodesModel

class SearchEpisodesByNameSource(
    private val apiService: ApiService,
    private val name: String
) : BasePagingSource<EpisodesDto, EpisodesModel>(
    request = { page -> apiService.getEpisodesByName(name, page) }
)
