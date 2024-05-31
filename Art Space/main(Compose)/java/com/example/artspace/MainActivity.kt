package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceUI()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceUI() {
    var count by remember {
        mutableIntStateOf(1)
    }
    val title: String
    val artist: String
    val year: String
    val imgID= when(count){
        1-> {
            title= stringResource(id = R.string.iron_man)
            artist= stringResource(id = R.string.iron_man_actor)
            year="(2008)"
            R.drawable.ironman
        }
        2 ->{
            title= stringResource(id = R.string.hulk)
            artist= stringResource(id = R.string.hulk_actor)
            year= "(2008)"
            R.drawable.incrediblehulk
        }
        3 -> {
            title= stringResource(id = R.string.thor)
            artist= stringResource(id = R.string.Thor_actor)
            year="(2011)"
            R.drawable.thor
        }
        else -> {
            title= stringResource(id = R.string.captain)
            artist= stringResource(id = R.string.captain_actor)
            year="(2011)"
            R.drawable.captainamerica
        }
    }
    Column(modifier= Modifier
        .statusBarsPadding()
        .padding(40.dp)
        .verticalScroll(rememberScrollState())

    ) {

        Surface(
            color = Color.White,
            modifier = Modifier
                .height(400.dp)
                .width(350.dp)
                .shadow(5.dp, shape = RectangleShape)
        ) {
            Image(painter = painterResource(id = imgID), contentDescription = title,
                alignment = Alignment.Center,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(20.dp)

            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column(modifier = Modifier
            .background(color = Color(0xFFECEBF4))
            .fillMaxWidth()
            .padding(10.dp)
        ) {
            Text(text = title,
                style = MaterialTheme.typography.displaySmall
            )
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append(artist)
                }
                withStyle(style = SpanStyle()){
                    append(" $year")
                }

            }
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(

        ) {
            Button(
                onClick = {
                    if(count!=1) count--
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_color)
                )
            ) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier
                .weight(1f))

            Button(onClick = {
                if(count!=4)count++
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.button_color)
                )) {
                Text(text = "Next",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceUI()
    }
}