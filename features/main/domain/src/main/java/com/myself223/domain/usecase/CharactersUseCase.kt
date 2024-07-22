package com.myself223.domain.usecase

import com.myself223.domain.repository.character.CharacterRepository

class   CharactersUseCase(private val repository: CharacterRepository) {
    operator fun invoke() = repository.getAllCharacters()
}