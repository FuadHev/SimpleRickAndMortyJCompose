package com.fuadhev.rickandmortyjetpack.data.remote.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Origin(
    val name: String,
    val url: String
): Serializable