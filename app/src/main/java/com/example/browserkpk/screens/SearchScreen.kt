package com.example.browserkpk.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.browserkpk.R
import com.example.browserkpk.controller.Screen


@Composable
fun WallpaperSearch(navController: NavController) {
    val background = painterResource(R.drawable.image_3)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // фон
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize()) {
        IconButton(
            modifier = Modifier
                .padding(end = 16.dp, top = 16.dp),
            onClick = {navController.navigate(Screen.Setting.route)}
        ) {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Settings",
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent),
                tint = Color.White
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WallpaperSearchPreview() {
//    val background = painterResource(R.drawable.image_3)
    WallpaperSearch(navController = rememberNavController( ))
}

