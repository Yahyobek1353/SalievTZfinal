package com.myself223.main.presentation.model

import com.myself223.domain.model.LocationModel

data class LocationUi (
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
)

fun LocationModel.toUi() = LocationUi(
    id = id, name = name,type = type,dimension = dimension
)