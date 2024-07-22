package com.myself223.data.remote.dto.location

import com.myself223.data.mapper.DataMapper
import com.myself223.domain.model.LocationModel

data class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
):DataMapper<LocationModel> {
    override fun toDomain() = LocationModel(
        id = id, name = name, type = type, dimension = dimension
    )
}
