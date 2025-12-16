package com.ui.states

import com.data.models.Character

sealed class CharacterListState {
    object Loading : CharacterListState()
    data class Error(val msg: String) : CharacterListState()
    data class Success(val characters: List<Character>) : CharacterListState()
    object Empty : CharacterListState()

}