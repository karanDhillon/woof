package com.example.androiddevchallenge.presentation.master

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.data.models.Dog
import com.example.androiddevchallenge.presentation.WoofViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogItemView(
    dog: Dog,
    onDogSelected: (dogId: Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        CoilImage(
            data = dog.imageUrl,
            modifier = Modifier.requiredSize(80.dp),
            contentDescription = "doggo",
            requestBuilder = {
                transformations(CircleCropTransformation())
            }
        )
        Spacer(modifier = Modifier.requiredSize(12.dp))
        Text(
            text = dog.name,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface
        )
    }
}