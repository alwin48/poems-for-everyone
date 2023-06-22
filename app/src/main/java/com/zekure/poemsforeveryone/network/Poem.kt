package com.zekure.poemsforeveryone.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Poem(
    val title: String,
    val author: String,
    val lines: List<String>,
    @SerialName(value = "linecount")
    val lineCount: String
)
