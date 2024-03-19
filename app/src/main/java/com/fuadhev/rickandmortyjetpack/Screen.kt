package com.fuadhev.rickandmortyjetpack

sealed class Screen(val route:String) {
    object CharactersScreen :Screen("characters")
    object CharacterDetailScreen :Screen("character_detail")
}