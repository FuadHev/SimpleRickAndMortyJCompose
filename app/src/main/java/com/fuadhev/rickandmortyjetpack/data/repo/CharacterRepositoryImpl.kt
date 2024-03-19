package com.fuadhev.rickandmortyjetpack.data.repo

import com.fuadhev.rickandmortyjetpack.data.remote.api.CharacterApiService
import com.fuadhev.rickandmortyjetpack.data.remote.model.CharactersDTO
import com.fuadhev.rickandmortyjetpack.data.remote.model.Result
import com.fuadhev.rickandmortyjetpack.domain.repo.CharacterRepository
import retrofit2.Response
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterApi:CharacterApiService) : CharacterRepository {
    override suspend fun getCharacters(
        name: String,
        status: String,
        gender: String
    ): Response<CharactersDTO> {
        return characterApi.getCharacters(name = name, status = status, gender = gender)
    }

    override suspend fun getCharacterDetail(id: Int): Response<Result> {
        return characterApi.getCharacterDetail(id)
    }

}