package com.myself223.domain.usecase

import com.myself223.domain.repository.episodes.EpisodesRepository

class EpisodesUseCase(private val repository: EpisodesRepository) {
    operator fun invoke() = repository.getAllEpisodes()
}