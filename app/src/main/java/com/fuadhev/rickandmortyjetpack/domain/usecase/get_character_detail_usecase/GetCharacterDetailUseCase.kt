package com.fuadhev.rickandmortyjetpack.domain.usecase.get_character_detail_usecase

import com.fuadhev.rickandmortyjetpack.domain.mapper.Mapper.toCharacterUiModel
import com.fuadhev.rickandmortyjetpack.domain.model.CharactersUiModel
import com.fuadhev.rickandmortyjetpack.domain.repo.CharacterRepository
import com.fuadhev.rickandmortyjetpack.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(val repo:CharacterRepository){

    fun getCharacterDetail(id:Int): Flow<Resource<CharactersUiModel>> = flow{
        emit(Resource.Loading)
        try {
            val resonse = repo.getCharacterDetail(id)
            if (resonse.isSuccessful){
                val character=resonse.body()
                emit(Resource.Success(character?.toCharacterUiModel()))
            }else{
                emit(Resource.Error("404 NOT FOUND"))

            }
        }catch (e:Exception){
            emit(Resource.Error(e.message?:"404 NOT FOUND"))
        }

    }
}