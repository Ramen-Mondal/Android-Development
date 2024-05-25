package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.TextColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUI(
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        phnNum = stringResource(id = R.string.phn_num),
                        share = stringResource(id = R.string.share_text),
                        mail = stringResource(id = R.string.mail_id)
                    )
                }
            }
        }
    }
}

@Composable
fun MainUI(name: String,title: String,phnNum: String,share: String,mail: String,
           modifier: Modifier=Modifier) {
    val image= painterResource(id = R.drawable.android_logo)
    val callImg= painterResource(id = R.drawable.call_img)
    val shareImg= painterResource(id = R.drawable.share_img)
    val mailImg= painterResource(id = R.drawable.mail_img)
    Column(Modifier.fillMaxSize()) {
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = image, contentDescription ="",
            modifier= Modifier
                .background(color = Color.Black)
                .size(130.dp))
        Text(text = name,
            fontSize = 35.sp)
        Text(text = title,
            color = TextColor
        )
    }
    }
    Row (
        modifier
            .fillMaxSize()
            .padding(bottom = 25.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
        ){
        Column (modifier.padding(end=15.dp)){
            Image(painter = callImg, contentDescription = "Call",modifier.padding(bottom = 15.dp))
            Image(painter = shareImg, contentDescription = "Share",modifier.padding(bottom = 15.dp))
            Image(painter = mailImg, contentDescription = "Mail",modifier.padding(bottom = 15.dp))
        }
        Column {
            Text(text = phnNum,modifier.padding(bottom = 15.dp))
            Text(text = share,modifier.padding(bottom = 15.dp))
            Text(text = mail,modifier.padding(bottom = 20.dp))
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MainUI( name = stringResource(id = R.string.name),
            title = stringResource(id = R.string.title),
            phnNum = stringResource(id = R.string.phn_num),
            share = stringResource(id = R.string.share_text),
            mail = stringResource(id = R.string.mail_id))
    }
}