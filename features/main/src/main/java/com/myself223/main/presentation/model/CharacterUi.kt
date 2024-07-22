package com.myself223.main.presentation.model

import com.myself223.domain.model.CharacterModel

data class CharacterUi(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
)
fun CharacterModel.toUi() =CharacterUi(
    id = id,
    name =  name,
    status = status,
    species = species,
    type = type,
    gender= gender,
    image = image
)