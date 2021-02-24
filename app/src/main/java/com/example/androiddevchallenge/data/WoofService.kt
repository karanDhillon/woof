package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.models.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface WoofService {
    @GET("v1/images/search?limit=100")
    suspend fun getDogs(): Response<List<DogResponse>>
}