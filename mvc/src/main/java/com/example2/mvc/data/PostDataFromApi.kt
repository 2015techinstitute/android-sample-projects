package com.example2.mvc.data

import kotlinx.serialization.Serializable

@Serializable
data class PostDataFromApi (
    val userId: Int,
    val id : Int,
    val title : String,
    val body: String
)