package com.myself223.domain.usecase

import com.myself223.domain.repository.location.LocationRepository

class LocationUseCase(private val repository: LocationRepository) {
    operator fun invoke() = repository.getAllLocation()
}