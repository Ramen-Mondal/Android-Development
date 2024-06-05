package com.example.superheroes.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroes.R

data class SuperHero(
  @StringRes val heroName: Int,
    @StringRes val superPower: Int,
    @DrawableRes val heroPic: Int
)
val superHeroes = listOf<SuperHero>(
  SuperHero(R.string.super_name1,R.string.super_power1,R.drawable.android_superhero1),
  SuperHero(R.string.super_name2,R.string.super_power2,R.drawable.android_superhero2),
  SuperHero(R.string.super_name3,R.string.super_power3,R.drawable.android_superhero3),
  SuperHero(R.string.super_name4,R.string.super_power4,R.drawable.android_superhero4),
  SuperHero(R.string.super_name5,R.string.super_power5,R.drawable.android_superhero5),
  SuperHero(R.string.super_name6,R.string.super_power6,R.drawable.android_superhero6)
)