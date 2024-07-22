package com.myself223.main.presentation.model

import com.myself223.domain.model.EpisodesModel

data class EpisodesUi (
    val id: Int,
    val name: String,
    val date: String,
    val episode: String,
)

fun EpisodesModel.toUi() = EpisodesUi(
    id = id, name = name, date = date, episode = episode
)