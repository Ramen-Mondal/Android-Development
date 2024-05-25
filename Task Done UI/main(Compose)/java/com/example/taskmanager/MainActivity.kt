package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskUI(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskUI(name: String, modifier: Modifier = Modifier) {
    val doneImg= painterResource(id = R.drawable.ic_task_completed)
    Column(modifier =Modifier.fillMaxSize()) {
        Image(painter = doneImg, contentDescription = "Task Completed",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "All tasks completed",
            modifier = Modifier.padding(
                top =24.dp,
                bottom = 8.dp
            )
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "Nice work!",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskUI("Android")
    }
}