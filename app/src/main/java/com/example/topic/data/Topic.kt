package com.example.topic.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val titleID: Int,
    val cost: Int,
    @DrawableRes
    val imageID: Int
)
