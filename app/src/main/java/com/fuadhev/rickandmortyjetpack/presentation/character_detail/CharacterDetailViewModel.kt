package com.fuadhev.rickandmortyjetpack.presentation.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fuadhev.rickandmortyjetpack.domain.usecase.get_character_detail_usecase.GetCharacterDetailUseCase
import com.fuadhev.rickandmortyjetpack.presentation.characters.CharactersState
import com.fuadhev.rickandmortyjetpack.utils.Constant.CHARACTER_ID
import com.fuadhev.rickandmortyjetpack.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {


    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    private var job: Job? = null

    init {
        savedStateHandle.get<String>(CHARACTER_ID)?.let {
            getCharacterDetail(it.toInt())
        }
    }

    fun getCharacterDetail(id:Int){
        job?.cancel()

        job = getCharacterDetailUseCase.getCharacterDetail(id).onEach {

            when(it){
                is Resource.Success->{_state.value=CharacterDetailState(character = it.data)}
                is Resource.Loading->{_state.value=CharacterDetailState(isLoading = true)}
                is Resource.Error->{_state.value=CharacterDetailState(error = it.exception)}
                else->{}
            }
        }.launchIn(viewModelScope)
    }


}