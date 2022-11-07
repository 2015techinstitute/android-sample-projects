package com.example2.mvc.data

import java.util.Observable
import kotlinx.serialization.Serializable

@Serializable
data class PostDataFromApiObserve(
    val userId: Int,
    val id : Int,
    val title : String,
    val body: String
): Observable()