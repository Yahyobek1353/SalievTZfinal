package com.myself223.main.presentation.module

import com.myself223.main.presentation.ui.fragments.characters.CharacterViewModel
import com.myself223.main.presentation.ui.fragments.episodes.EpisodesViewModel
import com.myself223.main.presentation.ui.fragments.locations.LocationViewModel
import org.koin.dsl.module


val uiModule = module {
    single { CharacterViewModel(get(),get(),get())}
    single { EpisodesViewModel(get(),get()) }
    single { LocationViewModel(get(),get()) }
}