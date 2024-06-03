package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseName: Int,
    val topicNum: Int,
    @DrawableRes val courseImg: Int
)
