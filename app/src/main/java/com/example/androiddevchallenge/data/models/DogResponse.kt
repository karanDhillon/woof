package com.example.androiddevchallenge.data.models

import com.squareup.moshi.Json

data class DogResponse(
     @Json(name = "breeds") val breeds: List<Breed>?,
     @Json(name = "id") val id: String?,
     @Json(name = "url") val url: String?
)

data class Breed(
     @Json(name = "weight") val weight: Weight?,
     @Json(name = "height") val height: Height?,
     @Json(name = "id") val id: Int?,
     @Json(name = "name") val name: String?,
     @Json(name = "bred_for") val bredFor: String?,
     @Json(name = "breed_group") val breedGroup: String?,
     @Json(name = "life_span") val lifeSpan: String?,
     @Json(name = "temperament") val temperament: String?,
)

data class Weight(
     @Json(name = "imperial") val imperial: String? = "",
     @Json(name = "metric") val metric: String? = ""
)

data class Height(
     @Json(name = "imperial") val imperial: String? = "",
     @Json(name = "metric") val metric: String? = ""
)