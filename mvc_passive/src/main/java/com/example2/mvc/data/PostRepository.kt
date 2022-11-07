package com.example2.mvc.data

import com.example2.mvc.data.PostDataFromApi
import retrofit2.Response

interface PostRepository {
    suspend fun getPosts(): Response<List<PostDataFromApi>>
}
