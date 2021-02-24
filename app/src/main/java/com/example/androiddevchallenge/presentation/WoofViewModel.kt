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
package com.example.androiddevchallenge.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.WoofRepository
import com.example.androiddevchallenge.data.models.Breed
import com.example.androiddevchallenge.data.models.Dog
import kotlinx.coroutines.launch

class WoofViewModel : ViewModel() {
    private val repository = WoofRepository()

    val dogs = MutableLiveData<List<Dog>>()
    val dogQuery = mutableStateOf("")

    init {
        viewModelScope.launch {
            dogs.value = repository
                .getDogBreeds()
                .map { mapBreedToDog(it) }
                .filter { dog ->
                    dog.name.isNotEmpty() || dog.name.isNotBlank()
                }
        }
    }

    fun onDogBreedSearchQueryChange(query: String) {
        viewModelScope.launch {
            dogs.value = repository
                .getDogBreeds()
                .filter { it.name?.toLowerCase()?.contains(query.toLowerCase()) ?: true }
                .map { mapBreedToDog(it) }
                .filter { dog ->
                    dog.name.isNotEmpty() || dog.name.isNotBlank()
                }
        }
    }

    private fun mapBreedToDog(breed: Breed): Dog {
        return Dog(
            id = breed.id ?: 0,
            name = breed.name ?: "",
            imageUrl = breed.image?.url ?: "",
            weight = breed.weight?.metric ?: "",
            height = breed.height?.metric ?: "",
            bredFor = breed.bredFor ?: "",
            breedGroup = breed.breedGroup ?: "",
            lifeSpan = breed.lifeSpan ?: "",
            temperament = breed.temperament ?: "",
            origin = breed.origin ?: "",
            description = breed.description ?: ""
        )
    }
}
