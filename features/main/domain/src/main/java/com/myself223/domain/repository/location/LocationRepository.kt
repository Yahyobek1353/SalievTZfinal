package com.myself223.domain.repository.location

import androidx.paging.PagingData
import com.myself223.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getAllLocation(): Flow<PagingData<LocationModel>>
    fun searchLocationByName(name: String): Flow<PagingData<LocationModel>>

}