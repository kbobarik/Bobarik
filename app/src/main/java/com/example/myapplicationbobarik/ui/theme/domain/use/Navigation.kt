package com.example.myapplicationbobarik.ui.theme.domain.use

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.Onboard
import com.example.myapplication.ui.theme.Pager
import com.example.myapplication.ui.theme.Start
import com.example.myapplicationbobarik.R
import com.example.myapplicationbobarik.ui.theme.InputCode
import com.example.myapplicationbobarik.ui.theme.presentation.Entrance

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route)
    {
        composable(route = Screen.MainScreen.route)
        {
            Start(navController = navController)

        }
        composable(route = Screen.Pager.route)
        {
            Pager(navController=navController)
        }
        composable(route = Screen.Entrance.route)
        {
            Entrance(navController = navController)
        }
        composable(route = Screen.InputCode.route)
        {
            InputCode(navController = navController)
        }


    }

}

