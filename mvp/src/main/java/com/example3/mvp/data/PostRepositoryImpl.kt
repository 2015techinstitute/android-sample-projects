package com.example3.mvp.data

import com.example3.mvp.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepositoryImpl (private val retrofitService: RetrofitService) : PostRepository {

    override suspend fun getAllPosts(): Response<List<PostDataFromApi>> {
        return withContext(Dispatchers.IO){
            retrofitService.getAllPosts()
        }
    }

    override suspend fun getPostById(id : Int): Response<PostDataFromApi> {
        return withContext(Dispatchers.IO){
            retrofitService.getPostById(id)
        }
    }
}