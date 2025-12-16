package com.data.datasources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private const val BASE_URL = "https://cdn.thesimpsonsapi.com/"

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    //Retrofir crea automaticamente una implementacion de CharacterApiService
    val apiService by lazy {
        retrofit
            .create(CharacterApiService::class.java)
    }

    val remoteDataSource by lazy { CharacterRemoteDataSource(apiService) }
}