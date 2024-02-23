package com.example.myapplicationbobarik.ui.theme.domain.use

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.Onboard
import com.example.myapplication.ui.theme.Start
import com.example.myapplicationbobarik.R

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route)
    {
        composable(route = Screen.MainScreen.route)
        {
            Start(navController = navController)

        }
        composable(route = Screen.Onboard.route)
        {
            Onboard(icon = R.drawable.doctor, button = "Пропустить", textView = "ugig", description = "ygutyfy")
        }



    }

}