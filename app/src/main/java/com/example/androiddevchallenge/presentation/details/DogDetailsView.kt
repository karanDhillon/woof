package com.example.androiddevchallenge.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
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