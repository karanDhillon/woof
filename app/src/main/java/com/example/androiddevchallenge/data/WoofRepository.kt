/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.data.models.Breed
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
