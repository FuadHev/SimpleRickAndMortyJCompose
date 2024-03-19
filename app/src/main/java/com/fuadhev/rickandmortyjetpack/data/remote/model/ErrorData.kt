package com.fuadhev.rickandmortyjetpack.data.remote.model


import com.google.gson.annotations.SerializedName

data class ErrorData(
    @SerializedName("error")
    val error: String
)