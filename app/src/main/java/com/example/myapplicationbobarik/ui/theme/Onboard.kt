package com.example.myapplication.ui.theme
import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationbobarik.R


@Composable
fun Onboard (icon: Int, button: String, textView: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(50.dp, 50.dp, 50.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(painter = painterResource(icon), contentDescription = null, contentScale = ContentScale.FillWidth,modifier = Modifier
            .padding(0.dp, 80.dp)
            .fillMaxWidth())

    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 250.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = textView, color = Color(0xFF00B712), fontSize = 20.sp, modifier = Modifier.padding(0.dp,20.dp))
        Text(text = description, color = Color(0xFF939396), fontSize = 14.sp)
        Canvas(
            modifier = Modifier
                .fillMaxSize()

        ) {
            drawCircle(style = Stroke(2f),color = Color(0xFF57A9FF),  radius = 25f, center = Offset(450f,200f))
            drawCircle(color =  Color(0xFF57A9FF), radius = 25f, center = Offset(550f,200f))
            drawCircle(color =  Color(0xFF57A9FF), radius = 25f, center = Offset(650f,200f))
        }


    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top


    ) {
        Text(text = button, color = Color(0xFF57A9FF), fontSize = 20.sp)
        Image(painter = painterResource(R.drawable.plus), contentDescription = null, contentScale = ContentScale.FillWidth,modifier = Modifier.width(167.dp))

    }
}


