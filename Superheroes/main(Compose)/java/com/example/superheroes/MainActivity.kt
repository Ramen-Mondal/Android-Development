package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.SuperHero
import com.example.superheroes.data.superHeroes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
               Surface (
                   modifier = Modifier.fillMaxSize()
               ) {
                   SuperheroesApp()
               }
            }
        }
    }
}

@Composable
fun SuperheroesApp() {
    Scaffold (
        topBar = { HeroesTopAppBar() }
    ) {innerPadding->
        LazyColumn (
            modifier = Modifier.padding(innerPadding)
        ) {
            items(superHeroes){
                SuperHero(
                    superHero =it,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_medium), vertical = dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopAppBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    })
}

@Composable
fun SuperheroesDetails(
    @StringRes heroName: Int,
    @StringRes heroPower: Int,
    @DrawableRes heroPic: Int,
    modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
    ) {
        Column (
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(id = heroName),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(id = heroPower),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        SuperHeroPic(heroPic = heroPic)
    }
}

@Composable
fun SuperHeroPic(
    @DrawableRes heroPic: Int,
    modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
    ){
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(dimensionResource(id = R.dimen.image_size)),
            painter = painterResource(id = heroPic),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun SuperHero(
    superHero: SuperHero,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ){
        SuperheroesDetails(
            heroName = superHero.heroName,
            heroPower = superHero.superPower ,
            heroPic = superHero.heroPic,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .sizeIn(minHeight = 72.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
        SuperheroesApp()
    }
}