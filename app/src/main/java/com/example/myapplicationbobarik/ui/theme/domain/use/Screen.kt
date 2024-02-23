package com.example.myapplicationbobarik.ui.theme.domain.use

sealed class Screen (val route:String) {
    object MainScreen : Screen("main_screen")
    object Onboard : Screen("on_board")

}