package com.myself223.data.remote.dto.characters

import com.myself223.data.mapper.DataMapper
import com.myself223.domain.model.CharacterModel

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
) : DataMapper<CharacterModel> {
    override fun toDomain() = CharacterModel(
        id,
        name,
        status,
        species,
        type,
        gender,
        image,
    )
}
