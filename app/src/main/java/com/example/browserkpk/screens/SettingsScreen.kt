package com.example.browserkpk.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.browserkpk.R
import com.example.browserkpk.controller.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(navController: NavHostController) {
    val background = painterResource(R.drawable.image_3)
//    WallpaperSearch(background, navController = rememberNavController( ))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)


            ) {
                Text(
                    text = " FAQ ",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                )
            }
            Box(
                modifier = Modifier
                    .align(CenterVertically)
            ) {
                IconButton(
                    onClick = { navController.navigate(Screen.Search.route) },
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "arrow back",
                        tint = Color.Black
                    )
                }
            }
        }



        InfoCard(
            "Test", "\n" +
                    "Сегодня в 14:20 в актовом зале состоится встреча, на которой представители Волонтерского центра РТУ МИРЭА выступят с презентацией о выездных волонтёрских мероприятиях (35 летних поездок, затрагивающие каждый уголок нашей необъятной страны, направленные на сохранение культурного наследия) в 2023 году\uD83D\uDE0D"
        )
        InfoCard(
            "Test", "\n" +
                    "Сегодня в 14:20 в актовом зале состоится встреча, на которой представители Волонтерского центра РТУ МИРЭА выступят с презентацией о выездных волонтёрских мероприятиях (35 летних поездок, затрагивающие каждый уголок нашей необъятной страны, направленные на сохранение культурного наследия) в 2023 году\uD83D\uDE0D"
        )
    }
}


@ExperimentalMaterialApi
@Composable
fun InfoCard(titleText: String = "", text: String = "") {

    var infoCardState by remember {
        mutableStateOf(false)
    }
    val rotateState by animateFloatAsState(targetValue = if (infoCardState) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .padding(bottom = 20.dp)
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300,
                    easing = LinearOutSlowInEasing,
                ),
            ),
//        shape = Shapes.medium,
        onClick = {
            infoCardState = !infoCardState
        }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = titleText,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(10f)
                )
                IconButton(
                    onClick = {
                        infoCardState = !infoCardState
                    },
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotateState),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown arrow"
                    )
                }
            }
            if (infoCardState) {
                Text(
                    text = text,
                    fontWeight = FontWeight.Normal,
                    maxLines = 10,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController())
}

