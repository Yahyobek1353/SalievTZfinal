package com.myself223.data.base.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.myself223.data.base.BasePagingSource
import com.myself223.data.mapper.DataMapper

fun <ValueDto:DataMapper<Value>,Value: Any> makePagingRequest(
    pagingSource: BasePagingSource<ValueDto,Value>,
    pageSize: Int = 20,
    prefetchDistance: Int = pageSize,
    enablePlaceholders: Boolean = true,
    initalLoadSize: Int = pageSize * 3,
    maxSize: Int = Int.MAX_VALUE,
    jumpThreshold: Int = Int.MIN_VALUE
) = Pager(
    config = PagingConfig(
        pageSize,
        prefetchDistance,
        enablePlaceholders,
        initalLoadSize,
        maxSize,
        jumpThreshold
    ),
    pagingSourceFactory = { pagingSource }).flow