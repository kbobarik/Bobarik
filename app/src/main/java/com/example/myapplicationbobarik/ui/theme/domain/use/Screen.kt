package com.example.myapplicationbobarik.ui.theme.domain.use

import ViewModelApi
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

sealed class Screen (val route:String) {

    object MainScreen : Screen("main_screen")
    object Pager : Screen("pager")
    object Entrance :Screen("entrance")
    object InputCode:Screen("input_code")

}