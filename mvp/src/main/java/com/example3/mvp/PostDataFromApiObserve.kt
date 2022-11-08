package com.example3.mvp

import java.util.Observable
import kotlinx.serialization.Serializable

@Serializable
data class PostDataFromApiObserve(
    val userId: Int,
    val id : Int,
    val title : String,
    val body: String
): Observable()