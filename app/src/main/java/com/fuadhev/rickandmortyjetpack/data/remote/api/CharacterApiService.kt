package com.fuadhev.rickandmortyjetpack.data.remote.api

import com.fuadhev.rickandmortyjetpack.data.remote.model.CharactersDTO
import com.fuadhev.rickandmortyjetpack.data.remote.model.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int=1,
        @Query("name") name: String = "",
        @Query("status") status: String = "",
        @Query("gender") gender: String = ""
    ): Response<CharactersDTO>

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") characterId:Int ):Response<Result>

}