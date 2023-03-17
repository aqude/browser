package com.example.browserkpk.screens

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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.browserkpk.R
import com.example.browserkpk.controller.Screen


@Composable
fun WallpaperSearch(navController: NavController) {
    var searchLink by remember {
        mutableStateOf("")
    }
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
    Column(modifier = Modifier
        .fillMaxSize())
    {
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth())
        {
            IconButton(
                modifier = Modifier
                    .padding(end = 16.dp, top = 16.dp),
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        )
        {
            Row(verticalAlignment = CenterVertically, modifier = Modifier.padding(horizontal = 40.dp)) {
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.White, RoundedCornerShape(20.dp))
                        .clip(RoundedCornerShape(20.dp))
                        ,
                    value = searchLink,
                    onValueChange = { searchLink = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(20.dp))
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.Search,
                        contentDescription = "search in internet"
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

