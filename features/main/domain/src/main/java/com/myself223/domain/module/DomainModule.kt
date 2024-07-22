package com.myself223.domain.module

import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.domain.usecase.EpisodesUseCase
import com.myself223.domain.usecase.FiltredCharactersUseCase
import com.myself223.domain.usecase.LocationUseCase
import com.myself223.domain.usecase.SearchCharacterUseCase
import com.myself223.domain.usecase.SearchEpisodesUseCase
import com.myself223.domain.usecase.SearchLocationUseCase
import org.koin.dsl.module

val useCaseModule = module {
     factory{ SearchCharacterUseCase(get()) }
     factory{ SearchEpisodesUseCase(get()) }
     factory{ SearchLocationUseCase(get()) }
     factory{ FiltredCharactersUseCase(get()) }
     factory{ CharactersUseCase(get()) }
     factory{ EpisodesUseCase(get()) }
     factory{ LocationUseCase(get()) }

}