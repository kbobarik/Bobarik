package com.example.myapplicationbobarik.ui.theme.domain.use

sealed class Screen (val route:String) {
    object MainScreen : Screen("main_screen")
    object Pager : Screen("pager")
    object Entrance :Screen("entrance")
    object InputCode:Screen("input_code")

}