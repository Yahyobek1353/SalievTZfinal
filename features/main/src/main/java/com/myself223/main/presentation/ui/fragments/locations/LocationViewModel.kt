package com.myself223.main.presentation.ui.fragments.locations

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.domain.usecase.LocationUseCase
import com.myself223.domain.usecase.SearchLocationUseCase
import com.myself223.main.presentation.model.EpisodesUi
import com.myself223.main.presentation.model.LocationUi
import com.myself223.main.presentation.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class LocationViewModel(
    private val locationUseCase: LocationUseCase,
    private val searchUseCase: SearchLocationUseCase
) : BaseViewModel() {

    private val _locationResults = MutableStateFlow<PagingData<LocationUi>>(PagingData.empty())
    val locationResults: StateFlow<PagingData<LocationUi>> = _locationResults.asStateFlow()

    private var currentSearchQuery: String? = null


    fun getLocation(): Flow<PagingData<LocationUi>> {
        return locationUseCase().map { pagingData ->
            pagingData.map { it.toUi() }
        }.cachedIn(viewModelScope)
    }
    fun searchLocation(name: String) {
        currentSearchQuery = name
        viewModelScope.launch {
            searchUseCase.searchLocationByName(name)
                .map { pagingData -> pagingData.map { it.toUi() } }
                .cachedIn(viewModelScope)
                .collectLatest { pagingData ->
                    _locationResults.value = pagingData
                }
        }
    }
}