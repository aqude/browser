package com.example.browserkpk.controller

const val BACKGROUND_COLOR = "color"
const val LINK = "link"

sealed class Screen(val route: String) {
    object Setting : Screen(route = "setting_screen")
//    object Setting : Screen(route = "setting_screen/{$BACKGROUND_COLOR}") {
//        fun passColor(color: androidx.compose.ui.graphics.Color): String {
//            return this.route.replace(oldValue = "{$BACKGROUND_COLOR}", newValue = color.toString())
//        }
//    }

    object Search : Screen(route = "search_screen")

    object WebViewScreen : Screen(route = "web_view_screen/{$LINK}") {
        fun passLink(link: String = "test"): String {
            return "web_view_screen/$link"
        }
    }


}