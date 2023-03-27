package com.example.browserkpk.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.browserkpk.screens.SettingsScreen
import com.example.browserkpk.screens.WallpaperSearch
import com.example.browserkpk.screens.WebViewScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Search.route
    ) {
        composable(
            route = Screen.Search.route,
//            arguments = listOf(navArgument(BACKGROUND_COLOR) {
//                type = NavType.StringType
//            })
        ) {
            // TODO Нужно добавить настройку для смены цвета
//            Log.d("Color: ", it.arguments?.getString(BACKGROUND_COLOR).toString())
            WallpaperSearch(navController = navController)
        }
        composable(
            route = Screen.Setting.route,
        ) {
            SettingsScreen(navController = navController)
        }
        composable(
            route = Screen.WebViewScreen.route,
            arguments = listOf(
                navArgument("link") {
                    type = NavType.StringType
                }
            )
        ) {
            WebViewScreen(navController = navController)
        }


    }

}