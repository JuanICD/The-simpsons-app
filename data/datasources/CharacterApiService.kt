package com.data.datasources

import retrofit2.http.GET
import retrofit2.http.Path
import com.data.models.Character
import java.net.URL

interface CharacterApiService {


    @GET(value = "api/character")
    suspend fun getCharacters(): List<Character>

    @GET(value = "api/character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character?



}