package com.example.myapplicationbobarik.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

import kotlin.time.Duration.Companion.seconds

@Preview
@Composable
fun code_input() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White))
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Введите код из E-mail", fontSize = 17.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {
                val focusRequester = remember { FocusRequester() }
                val max = 1;
                var code1:String by rememberSaveable { mutableStateOf("") }
                var code2:String by rememberSaveable { mutableStateOf("") }
                var code3:String by rememberSaveable { mutableStateOf("") }
                var code4:String by rememberSaveable { mutableStateOf("") }

                code(search = code1 , onValueChange = {if (it.length <= max) code1 = it } , modifier = Modifier.focusRequester(focusRequester))
                code(search = code2 , onValueChange = {if (it.length <= max) code2 = it } , modifier = Modifier.focusRequester(focusRequester))
                code(search = code3 , onValueChange = {if (it.length <= max) code3 = it } , modifier = Modifier.focusRequester(focusRequester))
                code(search = code4 , onValueChange = {if (it.length <= max) code4 = it } , modifier = Modifier.focusRequester(focusRequester))
                var codee = code1+code2+code3+code4


            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text = "Отправить код повторно можно",
                    fontSize = 15.sp,
                    color = Color(0xFF939396)
                )
                var timer by remember { mutableStateOf(60) }
                LaunchedEffect(key1 = timer) {
                    if (timer > 0) {
                        delay(1_000)
                        timer -= 1
                    }
                }

                Text (text = "будет через "+ timer.toString()+" секунд", fontSize = 15.sp, color = Color(0xFF939396))



            }
            }

        }
    }





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun code(
    search: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
)
{
    Box(modifier = Modifier
        .padding(end = 10.dp, start = 10.dp)
        .clip(RoundedCornerShape(10.dp)))
    {
        OutlinedTextField(
            value = search,
            keyboardOptions = KeyboardOptions(keyboardType =KeyboardType.NumberPassword),
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 20.sp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0XFFF5F5F9),
                focusedIndicatorColor = Color(0xFFEBEBEB),
                focusedTextColor = Color(0XFF578FFF),
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0XFF578FFF),
                focusedSupportingTextColor = Color(0xFF00000)
            ),
            modifier = Modifier
                .background(Color(0XFFF5F5F9))
                .height(height = 52.dp)
                .width(width = 52.dp))

    }

}

