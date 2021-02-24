package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.models.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface WoofService {
    @GET("v1/images/search?limit=100")
    @Headers("x_api_key: 2ca935e4-8c64-4f33-9b50-a5053c8fc393")
    suspend fun getDogs(): Response<List<DogResponse>>
}