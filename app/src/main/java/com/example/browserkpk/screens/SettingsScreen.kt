package com.example.browserkpk.screens

import android.util.Log
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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.browserkpk.controller.ColorSettings
import com.example.browserkpk.controller.Screen
import com.github.skydoves.colorpicker.compose.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(navController: NavHostController) {

//    val background = painterResource(R.drawable.image_3)
//    WallpaperSearch(background, navController = rememberNavController( ))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(horizontal = 20.dp)
    )
    {

        TopBar(navController)

        ColorPicker()

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

@Composable
fun ColorPicker() {
    val controller = rememberColorPickerController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AlphaTile(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(6.dp)),
                controller = controller
            )
        }
        HsvColorPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(10.dp),
            controller = controller,
            onColorChanged = {
                Log.d("Color", it.hexCode)
            }
        )
        AlphaSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(35.dp),
            controller = controller,
            tileOddColor = Color.White,
            tileEvenColor = Color.Black
        )
        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(35.dp),
            controller = controller,
        )
    }
}
@Composable
fun ColorGetter() {
    var colorSettings: ColorSettings by remember { mutableStateOf(ColorSettings(Color.DarkGray, Color.Gray)) }
    val controller = rememberColorPickerController()


//    HarmonyColorPicker(
//        color = colorSettings.backgroundColor,
//        onColorSelected = { colorSettings = colorSettings.copy(backgroundColor = it) }
//    )
//    ColorPicker(
//        color = colorSettings.textColor,
//        onColorSelected = { colorSettings = colorSettings.copy(textColor = it) }
//    )
//    Button(
//        onClick = {
//            // передача данных в основное окно
//            navigator.popAndPush(MainScreen(colorSettings))
//        },
//        modifier = Modifier.padding(top = 16.dp)
//    ) {
//        Text("Сохранить")
//    }

}
@Composable
fun TopBar(navController: NavHostController) {
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
                onClick = { navController.navigate(route = Screen.Search.route) },
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
                    delayMillis = 600,
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
            Row(verticalAlignment = CenterVertically) {
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

