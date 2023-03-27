package com.example.browserkpk.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
    ScaffoldScreen(navController, background)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldScreen(navController: NavController, background: Painter) {
    Scaffold(
        topBar = { TopBarSettings(navController) },
        backgroundColor = Color.Black,
        content = { MainContent(background, navController) }
    )
}

@Composable
fun TopBarSettings(navController: NavController) {
    IconButton(
        modifier = Modifier,
        onClick = { navController.navigate(route = Screen.Setting.route) }
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

@Composable
fun MainContent(background: Painter, navController: NavController) {
    var searchLink by remember {
        mutableStateOf("")
    }
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
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .padding(horizontal = 40.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
            ) {
                TextField(
                    modifier = Modifier.weight(1f),
                    value = searchLink,
                    onValueChange = { searchLink = it },
                    maxLines = 30,
                    label = { Text(text = "Поиск") }
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = { navController.navigate(Screen.WebViewScreen.passLink(searchLink)) },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search in internet"
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WallpaperSearchPreview() {
//    val background = painterResource(R.drawable.image_3)
    WallpaperSearch(navController = rememberNavController())
}

