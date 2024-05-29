package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import java.nio.channels.Selector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
               Surface(modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
                   ) {
                   LemonadePictureAndButton()
               }
            }
        }
    }
}

@Composable
fun LemonadePictureAndButton(modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(1)
    }
    val des: String
    val txt: String
    val img=when(count){
        1 ->  {
            des = stringResource(id = R.string.lemonTree)
            txt = stringResource(id = R.string.tapLemonTree)
            R.drawable.lemon_tree
        }
        2,3,4 ->  {
            des = stringResource(id = R.string.lemonTree)
            txt = stringResource(id = R.string.tapSqueeze)
            R.drawable.lemon_squeeze
        }
        5 -> {
            des = stringResource(id = R.string.lemonTree)
            txt = stringResource(id = R.string.tapLemonadeDrink)
            R.drawable.lemon_drink
        }
        else-> {
            des = stringResource(id = R.string.lemonTree)
            txt = stringResource(id = R.string.tapEmptyGlass)
            R.drawable.lemon_restart
        }
    }

    Column(modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(id = img), contentDescription = des,
                modifier = modifier.clickable { if(count!=6)count++ else count=1}
                )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = txt, fontSize = 18.sp)
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadePictureAndButton()
    }
}