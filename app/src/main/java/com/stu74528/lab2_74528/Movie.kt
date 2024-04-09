package com.stu74528.lab2_74528

import android.graphics.drawable.Drawable

class Movie (
    val name: String,
    val image: Int,
    val certification: String,
    val description: String,
    val starring: Array<String>,
    val runningTimeMins: Int,
    var seatsRemaining: Int,
    var seatsSelected: Int = 0
)