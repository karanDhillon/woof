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
package com.example.androiddevchallenge.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.data.models.Dog
import com.example.androiddevchallenge.presentation.WoofViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetailsView(
    dog: Dog,
    viewModel: WoofViewModel,
    popBackStack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Dog details")
                },
                navigationIcon = {
                    IconButton(onClick = { popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = dog.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(16.dp))
                CoilImage(
                    data = dog.imageUrl,
                    modifier = Modifier
                        .requiredSize(400.dp)
                        .align(Alignment.CenterHorizontally),
                    contentDescription = dog.name,
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    }
                )
                Spacer(modifier = Modifier.size(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "INFO",
                        fontWeight = FontWeight.Bold
                    )
                }
                DogStatView("Breed", dog.name)
                DogStatView("Bred For", dog.bredFor)
                DogStatView("Breed Group", dog.breedGroup)
                DogStatView("Height", dog.height)
                DogStatView("Weight", dog.weight)
                DogStatView("Lifespan", dog.lifeSpan)
                DogStatView("Origin", dog.origin)
                DogStatView("Temperament", dog.temperament)
                Spacer(modifier = Modifier.size(8.dp))
                if (dog.description.isNotBlank() || dog.description.isNotEmpty()) {
                    Text(
                        text = "Description",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = dog.description,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    )
}

@Composable
fun DogStatView(statName: String, statValue: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(0.3f, fill = false)
            ) {
                Text(
                    text = statName,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(0.7f, fill = true)
            ) {
                Text(
                    text = statValue,
                    modifier = Modifier.align(Alignment.End),
                    color = Color(0xFF3179EA),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            }
        }
        Divider(thickness = 1.dp)
    }
}
