package com.zekure.poemsforeveryone.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.zekure.poemsforeveryone.network.PoemApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val poemRepository: PoemRepository
}

class DefaultAppContainer : AppContainer {

    private val baseUrl =
        "https://poetrydb.org"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: PoemApiService by lazy {
        retrofit.create(PoemApiService::class.java)
    }

    override val poemRepository: PoemRepository by lazy {
        NetworkPoemRepository(retrofitService)
    }
}