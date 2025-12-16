package com.data.repositories

import com.data.datasources.CharacterRemoteDataSource
import com.data.models.Character


class CharacterRepository(private val remoteDataSource: CharacterRemoteDataSource) {

    suspend fun getCharacters(): List<Character> {
        return remoteDataSource
            .getCharacters()
            .map { character ->
                character.copy(
                    portrait_path = "https://cdn.thesimpsonsapi.com${character.portrait_path}"
                )

            }
    }

    suspend fun getCharacterById(id: Int) = remoteDataSource.getCharacterById(id)


}