package com.fuadhev.rickandmortyjetpack.domain.model

import com.fuadhev.rickandmortyjetpack.data.remote.model.Location
import com.fuadhev.rickandmortyjetpack.data.remote.model.Origin
import java.io.Serializable

data class CharactersUiModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
):Serializable