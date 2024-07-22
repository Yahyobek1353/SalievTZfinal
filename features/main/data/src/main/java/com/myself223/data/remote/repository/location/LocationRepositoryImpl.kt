package com.myself223.data.remote.repository.location

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.myself223.data.base.repository.makePagingRequest
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.sourse.LocationSource
import com.myself223.data.remote.sourse.SearchLocationByNameSource
import com.myself223.domain.model.LocationModel
import com.myself223.domain.repository.location.LocationRepository
import kotlinx.coroutines.flow.Flow



class LocationRepositoryImpl(private val api: ApiService) : LocationRepository {
    override fun getAllLocation(): Flow<PagingData<LocationModel>> =
        makePagingRequest(
        LocationSource(
            apiService = api
        )
    )

    override fun searchLocationByName(name: String): Flow<PagingData<LocationModel>> =
        Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { SearchLocationByNameSource(api, name) }
        ).flow

}