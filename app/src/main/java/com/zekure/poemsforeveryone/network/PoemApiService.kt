package com.zekure.poemsforeveryone.network

import retrofit2.http.GET
import retrofit2.http.Path

interface PoemApiService {
    @GET("author/{author}")
    suspend fun getRandomPoem(@Path("author") author: String): List<Poem>
}