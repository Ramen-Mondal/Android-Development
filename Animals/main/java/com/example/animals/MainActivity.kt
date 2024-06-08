package com.example.animals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animals.data.Animal
import com.example.animals.data.animalList
import com.example.animals.ui.theme.AnimalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalsTheme {
                AnimalsApp()
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimalsApp() {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    Scaffold (
        topBar = { AnimalsTopBar()}
    ) {innerPadding->

        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
            ),
            exit = fadeOut(),
            modifier = Modifier.padding(innerPadding)
        ){
            LazyColumn {
                itemsIndexed(animalList){index,animal->
                    RowAnimal(
                        animal = animal,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    animationSpec = spring(
                                        stiffness = StiffnessVeryLow,
                                        dampingRatio = DampingRatioLowBouncy
                                    ),
                                    initialOffsetY = { it * (index + 1) }
                                )
                            )
                    )
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalsTopBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = "30 Days Of Wild Animal",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
            )
    })
}

@Composable
fun RowAnimal(
   animal: Animal,
    modifier: Modifier = Modifier
) {
    var clicked by remember {
        mutableStateOf(false)
    }

    val color by animateColorAsState(
        targetValue = if(clicked) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.outlineVariant,
        label = ""
    )
    Card (
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ){
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clickable { clicked = !clicked }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = animal.dayCount,
                modifier =Modifier.padding(4.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(id = animal.animalName),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, bottom = 2.dp, start = 4.dp),
                style = MaterialTheme.typography.bodySmall
            )

            AnimalImages(
                animalPic = animal.animalPic,
                modifier = Modifier.fillMaxWidth()
                )
            if(clicked) {
                AboutAnimal(aboutAnimal = animal.aboutAnimal)
            }
        }
    }

}

@Composable
fun AnimalImages(
    @DrawableRes animalPic: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = animalPic),
        contentDescription = null ,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp))

    )
}

@Composable
fun AboutAnimal(
    @StringRes aboutAnimal: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = aboutAnimal),
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AnimalsAppPreview() {
    AnimalsTheme {
        AnimalsApp()
    }
}