package com.example.androiddevchallenge.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.models.Dog
import com.example.androiddevchallenge.data.WoofRepository
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

class WoofViewModel : ViewModel() {
    private val repository = WoofRepository()

    val dogs = MutableLiveData<List<Dog>>()

    init {
        viewModelScope.launch {
            dogs.value = repository
                .getDogs()
                .map {
                    Dog(
                        name = it.id ?: "",
                        imageUrl = it.url ?: ""
                    )
                }
        }
    }
}