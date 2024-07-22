package com.myself223.data.remote.dto

data class PaginationInfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)