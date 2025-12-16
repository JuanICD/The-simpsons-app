package com.data.datasources

import com.data.models.Character
import com.exceptions.CharacterNotExistException
import java.net.URL

class CharacterRemoteDataSource(private val apiService: CharacterApiService) {
    suspend fun getCharacters(): List<Character> {
        if (apiService.getCharacters().isEmpty()) {
            throw CharacterNotExistException("Characters not found")
        }
        return apiService.getCharacters()
    }

    suspend fun getCharacterById(id: Int): Character? {
        if (apiService.getCharacterById(id) == null) {
            throw CharacterNotExistException("Character not found")
        }
        return apiService.getCharacterById(id)
    }




}