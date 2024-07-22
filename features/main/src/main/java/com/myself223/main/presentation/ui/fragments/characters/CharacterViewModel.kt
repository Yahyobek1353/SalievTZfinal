package com.myself223.main.presentation.ui.fragments.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.domain.usecase.FiltredCharactersUseCase
import com.myself223.domain.usecase.SearchCharacterUseCase
import com.myself223.main.presentation.model.CharacterUi
import com.myself223.main.presentation.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val searchUseCase: SearchCharacterUseCase,
    private val useCase: FiltredCharactersUseCase
) : BaseViewModel() {
    init {
        getCharacter()
    }

    private val _characterResults = MutableStateFlow<PagingData<CharacterUi>>(PagingData.empty())
    val characterResults: StateFlow<PagingData<CharacterUi>> = _characterResults.asStateFlow()


    private var currentSearchQuery: String? = null
    private var currentFilters: CharacterFilters? = null
    fun getCharacter(): Flow<PagingData<CharacterUi>> {
        return charactersUseCase().map { pagingData ->
            pagingData.map { it.toUi() }
        }.cachedIn(viewModelScope)
    }

    fun searchCharacters(name: String) {
        currentSearchQuery = name
        viewModelScope.launch {
            searchUseCase.searchCharacterByName(name)
                .map { pagingData -> pagingData.map { it.toUi() } }
                .cachedIn(viewModelScope)
                .collectLatest { pagingData ->
                    _characterResults.value = pagingData
                }
        }
    }

    fun applyFilters(status: String?, species: String?, gender: String?) {
        currentFilters = CharacterFilters(status, species, gender)
        viewModelScope.launch {
            useCase.filter(status, species, gender)
                .map { pagingData -> pagingData.map { it.toUi() } }
                .cachedIn(viewModelScope)
                .collectLatest { pagingData ->
                    _characterResults.value = pagingData
                }
        }
    }

    fun resetFilters() {
        currentFilters = null
        if (currentSearchQuery != null) {
            searchCharacters(currentSearchQuery!!)
        } else {
            getCharacter()
        }
    }



    private data class CharacterFilters(val status: String?, val species: String?, val gender: String?)
}
