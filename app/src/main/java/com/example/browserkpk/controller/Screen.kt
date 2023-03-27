package com.example.browserkpk.controller

const val BACKGROUND_COLOR = "color"

sealed class Screen(val route: String) {
    object Setting : Screen(route = "setting_screen/{$BACKGROUND_COLOR}") {
        fun passColor(color: androidx.compose.ui.graphics.Color): String {
            return this.route.replace(oldValue = "{$BACKGROUND_COLOR}", newValue = color.toString())
        }
    }

    object Search : Screen(route = "search_screen")

    object WebViewScreen : Screen(route = "web-view_screen")
}