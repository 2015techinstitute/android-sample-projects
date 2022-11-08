package com.example3.mvp

import retrofit2.Response

interface PostRepository {
    suspend fun getAllPosts(): Response<List<PostDataFromApi>>
    suspend fun getPostById(id: Int): Response<PostDataFromApi>
}
