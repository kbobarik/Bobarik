package com.example.myapplication.ui.theme
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplicationbobarik.R
import com.example.myapplicationbobarik.ui.theme.domain.use.Screen


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Onboard (icon: Int, button: String, textView: String, description: String,navController: NavController, pagerState: PagerState) {
Surface (modifier = Modifier
    .fillMaxSize()
    .background(Color.Transparent)){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .padding(50.dp, 50.dp, 50.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(painter = painterResource(icon), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.width(375.dp).padding(bottom = 50.dp))

    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 250.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = textView, color = Color(0xFF00B712), fontSize = 20.sp, modifier = Modifier.padding(bottom = 20.dp))
        Text(text = description,textAlign = TextAlign.Center, color = Color(0xFF939396), fontSize = 14.sp, modifier = Modifier
            .padding(end = 10.dp, start = 10.dp, bottom = 20.dp))

        Row (modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement  = Arrangement.Center,
        ) {
            repeat(3){it->
                val color = if(pagerState.currentPage == it) Color(0xFF57A9FF) else Color.Transparent
                Box (modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .size(20.dp)
                    .background(color)
                    .border(1.dp, Color(0xFF57A9FF),CircleShape)
                )
            }

        }

    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,

    ) {
        Text(text = button, color = Color(0xFF57A9FF), fontSize = 20.sp, modifier = Modifier.clickable { navController.navigate(
            Screen.Entrance.route) })
        Image(painter = painterResource(R.drawable.plus), contentDescription = null, contentScale = ContentScale.FillWidth,modifier = Modifier.width(167.dp))

    }
}
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(navController:NavController)
{
    val pagerState = rememberPagerState (initialPage = 0){3}
    val button = listOf<String>("Пропустить","Пропустить","Завершить")
    val icon = listOf<Int>(R.drawable.kolba, R.drawable.people, R.drawable.doctor)
    val textView = listOf<String>("Анализы","Уведомления","Мониторинг")
    val description = listOf<String>("Экспресс сбор и получение проб","Вы быстро узнаете о результатах","Наши врачи всегда наблюдают за вашими показателями здоровья")
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)) {
        HorizontalPager(state = pagerState) {
                currentPage -> Onboard(icon = icon[currentPage],button = button[currentPage],textView = textView[currentPage],description = description[currentPage], navController= navController, pagerState = pagerState )
        }



    }


}





