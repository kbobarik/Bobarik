package com.example.myapplicationbobarik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplicationbobarik.ui.theme.Entrance

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Entrance()
            //Oneboard(R.drawable.plus, "hfbjhsfg","dkjfgbhjkdf", "sdkrjngfjlkd")


            }
        }
    }

