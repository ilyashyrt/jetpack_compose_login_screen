package com.ilyashayrat.composelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilyashayrat.composelogin.ui.theme.ComposeLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePage()
        }
    }
}

@Composable
fun HomePage() {
    Scaffold(
        backgroundColor = colorResource(id = R.color.backgroundColor),

        content = { Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            LionImage()
            CustomTextField("Username")
            CustomTextField("Password")
            SignInButton()


        }},

    )
}


@Composable
fun LionImage(){ // Lion picture
    Image(
        painter = painterResource(id = R.drawable.lionking),
        contentDescription = "",
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun CustomTextField(labelText: String){ // Username and Password TextField
    val tf = remember { mutableStateOf("")}
    TextField(
        placeholder = { Text(text = labelText) },
        value = tf.value,
        onValueChange = {tf.value = it},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,

        )
    )
}

@Composable
fun SignInButton(){ //Sign In Button
    Button(
        modifier = Modifier.size(height = 50.dp, width = 250.dp),
        onClick = {},
        colors =ButtonDefaults.buttonColors(
        backgroundColor = Color.Red,
    )) {
       Text(text = "Sign In", color = Color.White)
    }
}

