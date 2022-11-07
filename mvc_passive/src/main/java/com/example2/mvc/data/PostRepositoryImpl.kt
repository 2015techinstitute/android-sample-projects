package com.example2.mvc.data

import com.example2.mvc.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val retrofitService: RetrofitService) :
    PostRepository {

    override suspend fun getPosts(): Response<List<PostDataFromApi>> {
        return withContext(Dispatchers.IO){
            retrofitService.getAllPosts()
        }
    }
}