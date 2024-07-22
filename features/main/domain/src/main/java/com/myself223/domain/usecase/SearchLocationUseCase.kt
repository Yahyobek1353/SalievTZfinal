package com.myself223.domain.usecase

import androidx.paging.PagingData
import com.myself223.domain.model.LocationModel
import com.myself223.domain.repository.location.LocationRepository
import kotlinx.coroutines.flow.Flow

class SearchLocationUseCase(private val repository: LocationRepository) {

    fun searchLocationByName(name: String): Flow<PagingData<LocationModel>> {
        return repository.searchLocationByName(name)
    }
}
