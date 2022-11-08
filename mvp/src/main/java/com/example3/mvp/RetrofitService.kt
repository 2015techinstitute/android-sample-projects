package com.example3.mvp

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    companion object{
        fun getInstance(): RetrofitService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitService::class.java)
        }
    }

    @GET(Constants.BASE_URL + "posts")
    suspend fun getAllPosts(): Response<List<PostDataFromApi>>

    @GET(Constants.BASE_URL + "posts/{id}")
    suspend fun getPostById(@Path("id") id : Int): Response<PostDataFromApi>

}