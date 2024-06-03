package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.DataSource
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp() {
    Surface(modifier = Modifier.statusBarsPadding()) {
        TopicList(topicList = DataSource.loadCourses())
    }
}

@Composable
fun CourseCard(topic: Topic,modifier: Modifier = Modifier) {
    Card (
        modifier = modifier
    ) {
        Row {
            Image(painter = painterResource(id = topic.courseImg),
                contentDescription = stringResource(id = topic.courseName),
                modifier = Modifier
                    .size(height =68.dp, width = 68.dp)
                )
            Column {
                Text(text = stringResource(id = topic.courseName),
                    modifier =  Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row {
                   Icon(painter = painterResource(id = R.drawable.ic_grain),
                       contentDescription = null,
                       modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                       )
                    Text(text = "${topic.topicNum}",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun TopicList(topicList: List<Topic>,modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(topicList){ topic->
            CourseCard(topic = topic,
                modifier = Modifier.padding(8.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    CoursesTheme {
//        CoursesApp()
//    }
    CourseCard(topic = Topic(R.string.photography,45,R.drawable.photography))
}