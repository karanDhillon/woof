package com.example.androiddevchallenge.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.models.Dog
import com.example.androiddevchallenge.data.WoofRepository

class WoofViewModel : ViewModel() {
    private val repository = WoofRepository()

    val dogs =
        MutableLiveData(
            listOf(
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog(),
                Dog()
            )
        )
}