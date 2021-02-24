package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.models.Breed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WoofService {
    @GET("v1/breeds")
    @Headers("x_api_key: 2ca935e4-8c64-4f33-9b50-a5053c8fc393")
    suspend fun getBreeds(): Response<List<Breed>>

    @GET("v1/breeds/search")
    @Headers("x_api_key: 2ca935e4-8c64-4f33-9b50-a5053c8fc393")
    suspend fun getBreed(@Query("name") breedName: String): Response<Breed>
}