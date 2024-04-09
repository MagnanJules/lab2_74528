package com.stu74528.lab2_74528

sealed class Routes(val route: String) {
    object Home : Routes("HomeScreen")
    object Movie : Routes("MovieScreen")
    object ThirdScreen : Routes("third_screen")
}