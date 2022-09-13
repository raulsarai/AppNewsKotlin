package com.raul.appNewsKotlin.model

data class ResponseNews(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)