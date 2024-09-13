package com.example.loginapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Surface(
                    modifier= Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                ){
                    LoginUi()
                }
                }
            }
        }


}




@Preview(showBackground = true)
@Composable
fun LoginUi() {
    Column {
        val context= LocalContext.current
        val uname= remember{mutableStateOf("")}
        val pword= remember{ mutableStateOf("") }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Login Page",
            fontSize = 26.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .background(Color.Magenta)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(R.drawable.image),
            contentDescription =null,
            modifier= Modifier
                .height(250.dp)
                .fillMaxWidth()
            )

        OutlinedTextField(value = uname.value, onValueChange = {uname.value=it},
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            placeholder ={Text(text="username", fontStyle = Italic)}

        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = pword.value, onValueChange = {pword.value=it},
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            placeholder = {Text(text="password",fontStyle = Italic)}
     
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            Toast.makeText(context,"Successfully logged in!",Toast.LENGTH_SHORT).show()
        },modifier= Modifier.fillMaxWidth().padding(horizontal = 20.dp
        )) {
            Text(text="log in")
        }
    }
}



