package com.myself223.data.base.model

import com.myself223.data.remote.dto.PaginationInfoDto

data class BaseMainResponse<T>(
    val info: PaginationInfoDto,
    val results: List<T>
)