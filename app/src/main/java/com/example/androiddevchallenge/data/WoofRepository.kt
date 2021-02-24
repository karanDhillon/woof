package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.models.Breed
import com.example.androiddevchallenge.data.models.Dog
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class WoofRepository {
    suspend fun getDogBreeds(): List<Breed> {
        val response = getWoofService().getBreeds()
        val illegalAccessException = IllegalAccessException("Response from remote was not successful.")

        if (response.isSuccessful) return response.body() ?: throw illegalAccessException
        else throw illegalAccessException
    }

    suspend fun getDogBreed(breedName: String): Breed {
        val response = getWoofService().getBreed(breedName)
        val illegalAccessException = IllegalAccessException("Response from remote was not successful.")

        if (response.isSuccessful) return response.body() ?: throw illegalAccessException
        else throw illegalAccessException
    }

    private fun getWoofService(): WoofService {
        return getRetrofit().create(WoofService::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(getOkHttp())
            .baseUrl("https://api.thedogapi.com/")
            .addConverterFactory(getMoshiConverterFactory())
            .build()
    }

    private fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .connectTimeout(5, TimeUnit.MINUTES)
            .build()
    }

    private fun getMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create(getMoshi())
    }

    private fun getMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}