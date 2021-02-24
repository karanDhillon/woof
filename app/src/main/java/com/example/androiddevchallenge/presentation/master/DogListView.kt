package com.example.androiddevchallenge.presentation.master

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.androiddevchallenge.presentation.DogItemView
import com.example.androiddevchallenge.presentation.WoofViewModel

@Composable
fun DogListView(
    viewModel: WoofViewModel,
    onDogSelected: (dogId: Int) -> Unit
) {
    val dogs = viewModel.dogs.observeAsState()

    Column {
        dogs.value?.let {
            LazyColumn {
                items(
                    count = it.count(),
                    itemContent = {
                        DogItemView(
                            viewModel = viewModel,
                            onDogSelected = onDogSelected
                        )
                    }
                )
            }
        }
    }
}