package com.example.animals.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.animals.R

data class Animal(
    @StringRes val animalName: Int,
    @StringRes val aboutAnimal: Int,
    @DrawableRes val animalPic: Int,
    val dayCount: String
)

val animalList= listOf<Animal>(
    Animal(R.string.lion, R.string.about_lion,R.drawable.lion,"Day 1"),
    Animal(R.string.tiger, R.string.about_tiger,R.drawable.tiger,"Day 2"),
    Animal(R.string.cheetah, R.string.about_cheetah,R.drawable.cheetah,"Day 3"),
    Animal(R.string.wolf, R.string.about_wolf,R.drawable.wolf,"Day 4"),
    Animal(R.string.hyena, R.string.about_hyena,R.drawable.hyena,"Day 5"),
    Animal(R.string.fox, R.string.about_fox,R.drawable.fox,"Day 6"),
    Animal(R.string.bear, R.string.about_bear,R.drawable.bear,"Day 7"),
    Animal(R.string.elephant, R.string.about_elephant,R.drawable.elephent,"Day 8"),
    Animal(R.string.panda, R.string.about_panda,R.drawable.panda,"Day 9"),
    Animal(R.string.horse, R.string.about_horse,R.drawable.horse,"Day 10"),
    Animal(R.string.zebra, R.string.about_zebra,R.drawable.zebra,"Day 11"),
    Animal(R.string.buffalo, R.string.about_buffalo,R.drawable.buffalo,"Day 12"),
    Animal(R.string.giraffe, R.string.about_giraffe,R.drawable.giraffe,"Day 13"),
    Animal(R.string.gorilla, R.string.about_gorilla,R.drawable.gorila,"Day 14"),
    Animal(R.string.chimpanzee, R.string.about_chimpanzee,R.drawable.chimpanzees,"Day 15"),
    Animal(R.string.monkey, R.string.about_monkey,R.drawable.monkey,"Day 16"),
    Animal(R.string.pig, R.string.about_pig,R.drawable.pig,"Day 17"),
    Animal(R.string.deer, R.string.about_deer,R.drawable.deer,"Day 18"),
    Animal(R.string.sheep, R.string.about_sheep,R.drawable.sheep,"Day 19"),
    Animal(R.string.raccoon, R.string.about_raccoon,R.drawable.raccon,"Day 20"),
    Animal(R.string.koala, R.string.about_koala,R.drawable.koala,"Day 21"),
    Animal(R.string.sloth, R.string.about_sloth,R.drawable.sloth,"Day 22"),
    Animal(R.string.rabbit, R.string.about_rabbit,R.drawable.rabbit,"Day 23"),
    Animal(R.string.meerkat, R.string.about_meerkat,R.drawable.meerkat,"Day 24"),
    Animal(R.string.rat, R.string.about_rat,R.drawable.rat,"Day 25"),
    Animal(R.string.eagle, R.string.about_eagle,R.drawable.eagle,"Day 26"),
    Animal(R.string.peacock, R.string.about_peacock,R.drawable.peacock,"Day 27"),
    Animal(R.string.woodpecker, R.string.about_woodpecker,R.drawable.woodpecker,"Day 28"),
    Animal(R.string.crocodile, R.string.about_crocodile,R.drawable.crocodile,"Day 29"),
    Animal(R.string.tortoise, R.string.about_tortoise,R.drawable.tortoise,"Day 30")
)
