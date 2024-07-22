package com.myself223.data.remote.sourse

import com.myself223.data.base.BasePagingSource
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.dto.location.LocationDto
import com.myself223.domain.model.LocationModel

class SearchLocationByNameSource(
    private val apiService: ApiService,
    private val name: String
) : BasePagingSource<LocationDto, LocationModel>(
    request = { page -> apiService.getLocationByName(name, page) }
)
