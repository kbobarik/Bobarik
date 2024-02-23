package com.example.myapplicationbobarik.ui.theme.presentation

import ViewModelApi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationbobarik.ui.theme.InputCode
import com.example.myapplicationbobarik.ui.theme.domain.use.Navigation
import com.exaple.api.api.ReositoryImpl
import com.exaple.api.api.RetrofitInstance

class MainActivity : ComponentActivity() {
//    val viewModelSmart by viewModels<ViewModelApi>(factoryProducer = {
//        object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return ViewModelApi(ReositoryImpl(RetrofitInstance.apiSmartLab))
//                        as T
//            }
//        }
//    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()

            }
        }
    }

