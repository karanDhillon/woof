package com.example.androiddevchallenge.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogItemView(
    viewModel: WoofViewModel,
    onDogSelected: (dogId: Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        CoilImage(
            data = "https://cdn2.thedogapi.com/images/SkM9sec47_1280.jpg",
            modifier = Modifier.requiredSize(60.dp),
            contentDescription = "doggo",
            requestBuilder = {
                transformations(CircleCropTransformation())
            }
        )
        Spacer(modifier = Modifier.requiredSize(12.dp))
        Text(text = "Dog breed goes here", style = MaterialTheme.typography.h6)
    }
}