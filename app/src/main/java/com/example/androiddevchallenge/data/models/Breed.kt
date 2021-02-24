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