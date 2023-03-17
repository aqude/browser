package com.example.browserkpk.controller

sealed class Screen (val route: String) {
    object Setting: Screen(route = "setting_screen")
    object Search: Screen(route = "search_screen")
}