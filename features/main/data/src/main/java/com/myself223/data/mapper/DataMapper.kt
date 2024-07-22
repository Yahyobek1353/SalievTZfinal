package com.myself223.data.mapper

interface DataMapper<T> {
    fun toDomain():T
}