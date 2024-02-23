package com.example.myapplicationbobarik.ui.theme

import androidx.annotation.ContentView
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.isLiveLiteralsEnabled
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun InputCode(navController:NavController) {
    val textList = listOf(
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            )
        },
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            )
        },
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            )
        },
        remember {
            mutableStateOf(
                TextFieldValue(
                    text = "",
                    selection = TextRange(0)
                )
            )
        }

    )

    val requesterList = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
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
                    .align(Alignment.CenterHorizontally)
            ) {
                ContentView(textList,requesterList)
            }
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
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

                    Text(
                        text = "будет через " + timer.toString() + " секунд",
                        fontSize = 15.sp,
                        color = Color(0xFF939396)
                    )


                }
            }

        }
    }

fun nextFocus(
    textList: List<MutableState<TextFieldValue>>,
    requesterList: List<FocusRequester>
)
{
    for(index in textList.indices)
    {
        if(textList[index].value.text == "")
        {
            if(index<textList.size)
            {
                requesterList[index].requestFocus()
                break
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun inputWiew(
    value:TextFieldValue,
    onValueChange: (value:TextFieldValue) -> Unit,
    focusRequester: FocusRequester
)
{
    BasicTextField(
        readOnly = false,
        value = value,
        onValueChange = onValueChange,

        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .wrapContentSize()
            .background(Color(0xFFF5F5F9))
            .focusRequester(focusRequester)
            .border(1.dp,Color(0xFFEBEBEB)),
        singleLine = true,
        maxLines = 1,
        decorationBox = {
            innerTextField ->
            Box(modifier = Modifier
                .width(48.dp)
                .height(48.dp),
                contentAlignment = Alignment.Center,
                )
            {
                innerTextField()
            }

        },
        cursorBrush = SolidColor(Color.Black),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = null
        )
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable

fun ContentView(
    textList: List<MutableState<TextFieldValue>>,
    requesterList: List<FocusRequester>
)
{
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Surface(
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 50.dp)
                    .align(Alignment.Center)
            ) {
                for(i in textList.indices)
                {
                    inputWiew(
                        value = textList[i].value,
                        onValueChange = {newValue ->
                            if(textList[i].value.text!="")
                            {
                                if(newValue.text=="")
                                {
                                    textList[i].value = TextFieldValue(
                                        text = "",
                                        selection = TextRange(0)
                                    )
                                }
                                return@inputWiew
                            }
                            textList[i].value = TextFieldValue(
                                text = newValue.text,
                                selection = TextRange(newValue.text.length)
                            )
                            nextFocus(textList,requesterList)},
                        focusRequester = requesterList[i])
                }


            }
        }


    }

    LaunchedEffect(key1 = null, block = {
        delay(300)
        requesterList[0].requestFocus()
    })

}










