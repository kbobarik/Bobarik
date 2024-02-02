package com.example.myapplicationbobarik.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationbobarik.R

@Composable
fun Entrance() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp),
            verticalAlignment = Alignment.Top) {
            Image(painter = painterResource(id = R.drawable.hello), contentDescription = "", contentScale = ContentScale.FillWidth, modifier = Modifier.width(32.dp).padding(0.dp,16.dp, 0.dp,0.dp))
            Text(text = "Добро пожaловать!", fontSize = 24.sp, fontWeight = Bold, fontFamily = FontFamily.SansSerif )

        }

    }

}