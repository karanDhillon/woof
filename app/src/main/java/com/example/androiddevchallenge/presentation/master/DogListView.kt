package com.example.androiddevchallenge.presentation.master

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.presentation.WoofViewModel

@Composable
fun DogListView(
    viewModel: WoofViewModel,
    onDogSelected: (breedName: String) -> Unit
) {
    val dogs = viewModel.dogs.observeAsState()
    val dogQuery = viewModel.dogQuery

    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Woof")
                }
            )
        },
        content = {
            Column {
                TextField(
                    value = dogQuery.value,
                    onValueChange = {
                        dogQuery.value = it
                        viewModel.onDogBreedSearchQueryChange(it)
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    keyboardActions = KeyboardActions(onSearch = {
                        viewModel.onDogBreedSearchQueryChange(dogQuery.value)
                        focusManager.clearFocus(forcedClear = true)
                    }
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search,
                        keyboardType = KeyboardType.Text
                    )
                )

                dogs.value?.let {
                    LazyColumn {
                        items(
                            it,
                            itemContent = { dog ->
                                DogItemView(
                                    dog = dog,
                                    onDogSelected = onDogSelected
                                )
                            }
                        )
                    }
                }
            }
        }
    )
}