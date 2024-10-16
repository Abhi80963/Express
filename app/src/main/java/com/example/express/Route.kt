package com.example.express

import kotlinx.serialization.Serializable

@Serializable
object HomePageScreen

@Serializable
object LoginScreen

@Serializable
object SignUpScreen

@Serializable
data class NewsArticleScreen(
    val url: String
)