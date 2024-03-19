package com.fuadhev.rickandmortyjetpack.domain.mapper

import com.fuadhev.rickandmortyjetpack.data.remote.model.Result
import com.fuadhev.rickandmortyjetpack.domain.model.CharactersUiModel

object Mapper {
    fun List<Result>.toCharactersUiModelList() = map {
        CharactersUiModel(
            it.created,
            it.episode,
            it.gender,
            it.id,
            it.image,
            it.location,
            it.name,
            it.origin,
            it.species,
            it.status,
            it.type,
            it.url
        )
    }

    fun Result.toCharacterUiModel() =
        CharactersUiModel(
            created,
            episode,
            gender,
            id,
            image,
            location,
            name,
            origin,
            species,
            status,
            type,
            url
        )
}