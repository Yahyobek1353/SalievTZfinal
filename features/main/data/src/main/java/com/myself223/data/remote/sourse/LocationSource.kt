package com.myself223.data.remote.sourse

import com.myself223.data.base.BasePagingSource
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.dto.location.LocationDto
import com.myself223.domain.model.LocationModel

class LocationSource(
    private val apiService: ApiService
): BasePagingSource<LocationDto, LocationModel>({ page ->
    apiService.getLocation(
        page = page
    )
})