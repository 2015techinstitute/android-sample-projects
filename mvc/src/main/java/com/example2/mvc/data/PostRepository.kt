package com.example2.mvc.data

import retrofit2.Response

interface PostRepository {
    suspend fun getAllPosts(): Response<List<PostDataFromApi>>
    suspend fun getPostById(id: Int): Response<PostDataFromApi>
}
