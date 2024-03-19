package com.fuadhev.rickandmortyjetpack.data.remote.model


import com.google.gson.annotations.SerializedName

data class CharactersDTO(
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)