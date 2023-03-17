package com.example.browserkpk.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.browserkpk.screens.SettingsScreen
import com.example.browserkpk.screens.WallpaperSearch


@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Search.route
    ) {
        composable(
            route = Screen.Search.route
        ) {
            WallpaperSearch(navController = navController)
        }
        composable(
            route = Screen.Setting.route
        ) {
            SettingsScreen(navController = navController)
        }

    }

}