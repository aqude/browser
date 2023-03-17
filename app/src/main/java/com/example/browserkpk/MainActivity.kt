package com.example.browserkpk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.browserkpk.controller.SetupNavGraph
import com.example.browserkpk.ui.theme.BrowserKPKTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrowserKPKTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

//@Composable
//fun CircularButtonWithNavigation(navController: NavController) {
//    Box(
//        modifier = Modifier
//            .size(60.dp)
//            .clip(CircleShape)
//            .background(Color.Blue)
//            .clickable {
//                navController.navigate("newComponent")
//            },
//        contentAlignment = Alignment.Center
//    ) {
//        Icon(
//            painter = painterResource(id = R.drawable.baseline_settings_24),
//            contentDescription = "Add",
//            tint = Color.White
//        )
//    }
//}



