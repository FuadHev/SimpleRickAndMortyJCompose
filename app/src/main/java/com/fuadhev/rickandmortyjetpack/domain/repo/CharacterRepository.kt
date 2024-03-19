package com.fuadhev.rickandmortyjetpack.domain.repo

import com.fuadhev.rickandmortyjetpack.data.remote.model.CharactersDTO
import com.fuadhev.rickandmortyjetpack.data.remote.model.Result
import retrofit2.Response
import retrofit2.http.Query

interface CharacterRepository {

    suspend fun getCharacters(
        name: String = "",
        status: String = "",
        gender: String = ""
    ): Response<CharactersDTO>


    suspend fun getCharacterDetail(id:Int):Response<Result>

}