package com.myself223.data.module

import com.myself223.data.remote.repository.character.CharacterRepositoryImpl
import com.myself223.data.remote.repository.episodes.EpisodesRepositoryImpl
import com.myself223.data.remote.repository.location.LocationRepositoryImpl
import com.myself223.domain.repository.character.CharacterRepository
import com.myself223.domain.repository.episodes.EpisodesRepository
import com.myself223.domain.repository.location.LocationRepository
import org.koin.dsl.module

val repoModule = module {
    single<CharacterRepository>{ CharacterRepositoryImpl(get()) }
    single<EpisodesRepository>{ EpisodesRepositoryImpl(get()) }
    single<LocationRepository>{ LocationRepositoryImpl(get()) }
}