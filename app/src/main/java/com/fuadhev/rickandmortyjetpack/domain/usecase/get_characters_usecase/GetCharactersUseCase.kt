package com.fuadhev.rickandmortyjetpack.domain.usecase.get_characters_usecase

import com.fuadhev.rickandmortyjetpack.domain.mapper.Mapper.toCharactersUiModelList
import com.fuadhev.rickandmortyjetpack.domain.model.CharactersUiModel
import com.fuadhev.rickandmortyjetpack.domain.repo.CharacterRepository
import com.fuadhev.rickandmortyjetpack.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(val repo:CharacterRepository){

    fun getCharacters(
        name: String = "",
        status: String = "",
        gender: String = ""
    ): Flow<Resource<List<CharactersUiModel>>> = flow {
        try {
            emit(Resource.Loading)
            val response=repo.getCharacters(name=name,status=status,gender=gender)
            if (response.isSuccessful){
                val body=response.body()?.results
                val characterList=body?.let {
                    it.toCharactersUiModelList()
                }?: emptyList()
                emit(Resource.Success(characterList))
            }

        }catch (e:Exception){
            emit(Resource.Error(e.message?:"404 NOT FOUND"))
        }
    }
}