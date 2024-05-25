package com.example.composearticale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticale.ui.theme.ComposeArticaleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticaleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UIDesign(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UIDesign(name: String, modifier: Modifier = Modifier) {
    val headImg = painterResource(id = R.drawable.bg_compose_background)

    Column {
        Image(
            painter = headImg,
            contentDescription = null
        )
        Text(text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier= Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(text ="Jetpack Compose is a modern toolkit for building native Android UI. " +
                "Compose simplifies and accelerates UI development on Android with less code," +
                " powerful tools, and intuitive Kotlin APIs.",
            textAlign = TextAlign.Justify,
            modifier= Modifier.padding(
                start =16.dp,
                end =16.dp
            )

        )
        Text(text = "In this tutorial, you build a simple UI component with declarative functions." +
                " You call Compose functions to say what elements you want and the Compose compiler" +
                " does the rest. Compose is built around Composable functions. These functions let" +
                " you define your app\'s UI programmatically because they let you describe how it " +
                "should look and provide data dependencies, rather than focus on the process of the" +
                " UI\'s construction, such as initializing an element and then attaching it to a " +
                "parent. To create a Composable function, you add the @Composable annotation to the" +
                " function name.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)

        )
    }
}
@Composable
fun TextDesign(text: String, modifier: Modifier =Modifier){
    Text(text = text)
}

@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeArticaleTheme {
        UIDesign("Android")
    }
}