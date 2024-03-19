package com.fuadhev.rickandmortyjetpack.presentation.characters

import com.fuadhev.rickandmortyjetpack.domain.model.CharactersUiModel

data class CharactersState (
    val isLoading : Boolean = false,
    val characters : List<CharactersUiModel> = emptyList(),
    val error : String = "",
)