package com.zekure.poemsforeveryone.network

import retrofit2.http.GET

interface PoemApiService {
    @GET("random/1")
    suspend fun getRandomPoem(): List<Poem>
}