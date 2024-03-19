package com.fuadhev.rickandmortyjetpack.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fuadhev.rickandmortyjetpack.domain.usecase.get_characters_usecase.GetCharactersUseCase
import com.fuadhev.rickandmortyjetpack.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersUseCase: GetCharactersUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    private var job: Job? = null

    init {
        getCharacters()
    }

    fun getCharacters(
        name: String = "",
        status: String = "",
        gender: String = ""
    ) {
        job?.cancel()

        job = charactersUseCase.getCharacters(name, status, gender).onEach {

            when (it) {
                is Resource.Loading -> {
                    _state.value = CharactersState(isLoading = true)
                }

                is Resource.Success -> {
                    it.data?.let { data ->
                        _state.value = CharactersState(characters = data)
                    }
                }

                is Resource.Error -> {
                    _state.value = CharactersState(error = it.exception)
                }

                else -> {}
            }
        }.launchIn(viewModelScope)

    }
}