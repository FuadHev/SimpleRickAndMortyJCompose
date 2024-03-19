package com.fuadhev.rickandmortyjetpack.presentation.character_detail

import com.fuadhev.rickandmortyjetpack.domain.model.CharactersUiModel

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharactersUiModel? = null,
    val error: String = ""
)