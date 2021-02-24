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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.presentation.details.DogDetailsView
import com.example.androiddevchallenge.presentation.master.DogListView
import com.example.androiddevchallenge.presentation.theme.MyTheme

class MainActivity : AppCompatActivity() {
    private val woofViewModel: WoofViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Navigation.MasterScreen.title
                ) {
                    composable(Navigation.MasterScreen.title) {
                        DogListView(
                            woofViewModel,
                            onDogSelected = { breedName ->
                                navController.navigate(Navigation.DetailScreen.title + "/$breedName")
                            }
                        )
                    }

                    composable(
                        Navigation.DetailScreen.title + "/{breedName}",
                        arguments = listOf(navArgument("breedName") { type = NavType.StringType })
                    ) { navBackStackEntry ->
                        val breedName: String? = navBackStackEntry.arguments?.getString("breedName")
                        val dog = woofViewModel.dogs.value?.first { it.name == breedName }

                        DogDetailsView(
                            dog = dog!!,
                            viewModel = woofViewModel,
                            popBackStack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
