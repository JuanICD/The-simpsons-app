package com.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.repositories.CharacterRepository
import com.ui.states.CharacterListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.data.models.Character

class CharacterListViewModel(private val repository: CharacterRepository) : ViewModel() {

    private val _characterListState =
        MutableStateFlow<CharacterListState>(CharacterListState.Loading)

    val characterListState: StateFlow<CharacterListState> = _characterListState

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            try {
                _characterListState.value = CharacterListState.Loading
                val characters: List<Character> = repository.getCharacters()
                if (characters.isEmpty()) {
                    _characterListState.value = CharacterListState.Empty
                } else {
                    _characterListState.value = CharacterListState.Success(characters)
                }


            } catch (e: Exception) {
                _characterListState.value = CharacterListState.Error(e.message ?: "Error")
            }
        }
    }



}