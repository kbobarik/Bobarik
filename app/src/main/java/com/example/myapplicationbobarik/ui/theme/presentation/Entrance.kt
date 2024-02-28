package com.example.myapplicationbobarik.ui.theme.presentation

import ViewModelApi
import android.util.Patterns
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplicationbobarik.R
import com.example.myapplicationbobarik.ui.theme.domain.use.Screen
import com.example.myapplicationbobarik.ui.theme.domain.use.EmailViewModel

@Composable
fun Entrance(navController:NavController,viewModelApi: ViewModelApi){

    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp, 80.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 20.dp),
                verticalAlignment = Alignment.Top

            ) {
                Image(
                    painter = painterResource(id = R.drawable.hello),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.width(32.dp)
                )
                Text(
                    text = "Добро пожaловать!",
                    fontSize = 25.sp,
                    fontWeight = Bold,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.offset(16.dp, 0.dp)
                )

            }
            Text(
                text = "Войдите, чтобы пользоваться функциями приложения",
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif
            )

            Surface(modifier = Modifier.fillMaxSize()) {
                val viewModel = viewModel<EmailViewModel>()
                val state = viewModel.state
                Column(
                    Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 50.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Вход по E-mail", fontSize = 14.sp, fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(bottom = 10.dp))
                    CustomEmail(search = state.email, onValueChange = { viewModel.onEvent(RegistrationEvent.EmailChanged(it))
                    }, isError = state.emailError!=null)
                    if (state.emailError!=null)
                    {
                        Text(text = state.emailError, color = MaterialTheme.colorScheme.error)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
                        Button(
                            onClick = {viewModelApi.sendCodeToEmail(state.email)
                                navController.navigate(
                                    Screen.InputCode.route) },
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .width(width = 500.dp)
                                .height(height = 56.dp),
                            shape = RoundedCornerShape(size = 12.dp),
                            colors = ButtonDefaults.buttonColors(

                                containerColor = Color(0xFF1A6FEE),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Далее", fontSize = 17.sp)
                        }
                    }else
                    {
                        Button(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .width(width = 500.dp)
                                .height(height = 56.dp),
                            onClick = {viewModel.onEvent(RegistrationEvent.submit)},
                            shape = RoundedCornerShape(size = 12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFC9D4FB),
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Далее", fontSize = 17.sp)
                        }

                    }




                }

            }
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(bottom = 20.dp), text = "Или войдите с помощью", fontSize = 15.sp, fontFamily = FontFamily.SansSerif, color = Color(0xFF939396))
            Button(modifier = Modifier
                .width(width = 335.dp)
                .height(height = 60.dp),onClick = {},shape = RoundedCornerShape(size = 12.dp), border = BorderStroke(1.dp, Color(0xFFEBEBEB)),colors = ButtonDefaults.buttonColors(containerColor = Color.White,contentColor = Color.Black)) {
                Text(text =  "Войти с Яндекс", fontSize = 17.sp)
            }





        }

    }

}







@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEmail(
    search: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    isError: Boolean
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0XFFE8EFFF))

    ) {
        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            isError = isError,
            value = search,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 15.sp),
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
                .fillMaxWidth(1f)
                .background(Color(0XFFF5F5F9))
                .height(height = 50.dp)
                .width(width = 335.dp),
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "example@mail.ru",
                    fontSize = 15.sp,
                    color = Color(0XFF939396)
                )
            }
        )

    }
}



