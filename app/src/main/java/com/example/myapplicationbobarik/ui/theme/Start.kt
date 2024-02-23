package com.example.myapplication.ui.theme
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplicationbobarik.R
import com.example.myapplicationbobarik.ui.theme.domain.use.Screen
import kotlinx.coroutines.delay

@Composable
fun Start(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize(1f)
        .background(
            Brush.linearGradient(
            colors = listOf(
                Color(161, 202, 255),
                Color(77, 156, 255),
                Color(161, 202, 255)
            ), start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
        )

        .background(
            Brush.verticalGradient(
            colors = listOf(
                Color(116, 200, 228),
                Color(115, 213, 188),
                Color(116, 200, 228)
            )
            )

        )
        .background(
            Brush.verticalGradient(
            colors = listOf(
                Color(98, 105, 240).copy(alpha = 0.05f),
                Color(55, 64, 245).copy(alpha = 0.65f),
                Color(34, 84, 245).copy(alpha = 1f),
                Color(55, 64, 245,).copy(alpha = 0.65f),
                Color(98, 105, 240,).copy(alpha = 0.05f)
            )
        )
        )
    ){        Canvas(
        modifier = Modifier
            .fillMaxSize()
            .blur(radius = 100.dp)
    ) {
        drawCircle(color = Color(0xFF4460C1), radius = 500f, center = Offset(80f,100f))
        drawCircle(color =  Color(0xFF4460C1), radius = 500f, center = Offset(1000f,2350f))
    }
        Column(modifier = Modifier
        .fillMaxSize(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center )
        {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "", contentScale = ContentScale.FillWidth, modifier = Modifier.width(263.dp))        }

    }
    var timer by remember { mutableStateOf(1.5) }
    LaunchedEffect(key1 = timer) {
        if (timer > 0) {
            delay(1_000)
            timer -= 1

        }
        else if(timer <= 0.0)
        {
            navController.navigate(Screen.Pager.route)
        }


    }



}