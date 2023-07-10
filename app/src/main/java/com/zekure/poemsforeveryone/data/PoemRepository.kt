package com.zekure.poemsforeveryone.data

import com.zekure.poemsforeveryone.network.Poem
import com.zekure.poemsforeveryone.network.PoemApiService

interface PoemRepository {
    suspend fun getRandomPoem(): List<Poem>
}

class NetworkPoemRepository(
    private val poemApiService: PoemApiService
): PoemRepository {
    override suspend fun getRandomPoem(): List<Poem> = poemApiService.getRandomPoem("shakespeare")
}