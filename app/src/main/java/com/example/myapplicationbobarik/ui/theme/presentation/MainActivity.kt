package com.example.myapplicationbobarik.ui.theme.presentation

import ViewModelApi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.theme.Onboard
import com.example.myapplicationbobarik.ui.theme.InputCode
import com.example.myapplicationbobarik.ui.theme.domain.use.Navigation
import com.exaple.api.api.ReositoryImpl
import com.exaple.api.api.RetrofitInstance
import kotlin.time.TimeSource

class MainActivity : ComponentActivity() {
        val viewModelSmart by viewModels<ViewModelApi>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModelApi(ReositoryImpl(RetrofitInstance.apiSmartLab))
                        as T
            }
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             Navigation(viewModelSmart)

        }
    }
}




