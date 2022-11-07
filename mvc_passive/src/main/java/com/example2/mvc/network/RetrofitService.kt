package com.example2.mvc.network

import com.example2.mvc.data.PostDataFromApi
import com.example2.mvc.common.Constants
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    /* Call current weather data by city name */
    @GET(Constants.BASE_URL + "posts")
    suspend fun getAllPosts(): Response<List<PostDataFromApi>>

}