package com.example.myapplicationbobarik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.ui.theme.Onboard
import com.example.myapplicationbobarik.ui.theme.Entrance
import com.example.myapplicationbobarik.ui.theme.code_input

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            code_input()
            }
        }
    }

