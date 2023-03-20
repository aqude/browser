package com.example.browserkpk.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.browserkpk.controller.Screen
import com.github.skydoves.colorpicker.compose.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen(navController: NavHostController) {
    val lazyListState = rememberLazyListState()
    val hexColor: String = ColorPicker()
    val color = Color(hexColor.toLong(16).toInt())

//    val background = painterResource(R.drawable.image_3)
//    WallpaperSearch(background, navController = rememberNavController( ))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(horizontal = 20.dp),
    )
    {

        TopBar(navController)

//        ColorPicker()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
                .padding(horizontal = 20.dp),
            state = lazyListState
        ) {
            item {
                InfoCard(
                    "О бразуере", "\n" + "" +
                            "Иновационный бразуер который умеет искать информацию!"
                )
            }
            item {
                InfoCard(
                    "О разработчиках", "\n" +
                            "Приходит как-то Гитлер на совещание, а поперек комнаты стоит огромный железный ящик. Гитлер спрашивает у Мюллера:\n" +
                            "- Это еще что такое?\n" +
                            "- А... это Штирлиц установил новейшее советское компьютерное миниатюрное подслушивающее устройство, - пояснил Мюллер.\n" +
                            "- А чего же вы его не вытащите отсюда, если уж обнаружили? - раскричался Гитлер.\n" +
                            "- Мы бы, мой фюрер, с удовольствием! Только его никто поднять не может.\n"

                )
            }
            item {
                InfoCardSettings(
                    "Смените цвет фона!", "Смените цвет фона"
                ) {
                    ColorPicker()
                }
            }
        }
    }
}

@Composable
fun ColorPicker(): String {
    val controller = rememberColorPickerController()
    var selectedColor by remember { mutableStateOf(Color.Black) }
    var colorHex by remember { mutableStateOf("FF3551FF") } // изменение цвета должно быть хранимым состоянием

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically
        ) {
            AlphaTile(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(6.dp)),
                controller = controller,
            )
        }
        HsvColorPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            controller = controller
        ) { colorEnvelope: ColorEnvelope ->
            selectedColor = colorEnvelope.color
            colorHex = colorEnvelope.hexCode
        }
        Button(onClick = { Log.d("Color", colorHex)}) {
            Text(text = "Сохранить")
        }
    }
    return colorHex // возвращаем выбранный цвет
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InfoCardSettings(titleText: String, bottomInfo: String, composable: @Composable () -> Unit) {

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
                composable()
                Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = bottomInfo, fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.h6.fontSize
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
                    maxLines = 20,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                )
            }
        }
    }
}


@Composable
//@Preview(showBackground = true)
fun SettingsScreenPreview() {
    SettingsScreen(navController = rememberNavController())
}

