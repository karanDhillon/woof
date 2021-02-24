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
package com.example.androiddevchallenge.data.models

import com.squareup.moshi.Json

data class Breed(
    @Json(name = "weight") val weight: Weight?,
    @Json(name = "height") val height: Height?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "bred_for") val bredFor: String?,
    @Json(name = "breed_group") val breedGroup: String?,
    @Json(name = "life_span") val lifeSpan: String?,
    @Json(name = "temperament") val temperament: String?,
    @Json(name = "origin") val origin: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "image") val image: Image?
)

data class Weight(
    @Json(name = "imperial") val imperial: String? = "",
    @Json(name = "metric") val metric: String? = ""
)

data class Height(
    @Json(name = "imperial") val imperial: String? = "",
    @Json(name = "metric") val metric: String? = ""
)

data class Image(
    @Json(name = "url") val url: String? = ""
)
