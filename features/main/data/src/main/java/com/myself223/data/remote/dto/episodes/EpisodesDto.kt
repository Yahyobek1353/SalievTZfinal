package com.myself223.data.remote.dto.episodes

import com.google.gson.annotations.SerializedName
import com.myself223.data.mapper.DataMapper
import com.myself223.domain.model.EpisodesModel

data class EpisodesDto (
    val id: Int,
    val name: String,
    @SerializedName("air_date")
    val date: String,
    val episode: String,
):DataMapper<EpisodesModel> {
    override fun toDomain() = EpisodesModel(
        id = id, name= name, date = date, episode = episode
    )
}