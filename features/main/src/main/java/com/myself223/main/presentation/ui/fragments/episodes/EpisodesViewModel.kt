package com.myself223.main.presentation.ui.fragments.episodes

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.domain.usecase.EpisodesUseCase
import com.myself223.domain.usecase.SearchEpisodesUseCase
import com.myself223.main.presentation.model.CharacterUi
import com.myself223.main.presentation.model.EpisodesUi
import com.myself223.main.presentation.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class EpisodesViewModel(
    private val episodesUseCase: EpisodesUseCase,
    private val searchUseCase: SearchEpisodesUseCase
) : BaseViewModel() {
    private val _episodesResults = MutableStateFlow<PagingData<EpisodesUi>>(PagingData.empty())
    val episodesResults: StateFlow<PagingData<EpisodesUi>> = _episodesResults.asStateFlow()

    private var currentSearchQuery: String? = null


    fun getEpisodes(): Flow<PagingData<EpisodesUi>> {
        return episodesUseCase().map { pagingData ->
            pagingData.map { it.toUi() }
        }.cachedIn(viewModelScope)
    }
    fun searchEpisodes(name: String) {
        currentSearchQuery = name
        viewModelScope.launch {
            searchUseCase.searchEpisodesByName(name)
                .map { pagingData -> pagingData.map { it.toUi() } }
                .cachedIn(viewModelScope)
                .collectLatest { pagingData ->
                    _episodesResults.value = pagingData
                }
        }
    }
}