package com.example.androiddevchallenge.presentation

sealed class Navigation(val title: String) {
    object MasterScreen : Navigation("MasterScreen")
    object DetailScreen : Navigation("DetailScreen")
}