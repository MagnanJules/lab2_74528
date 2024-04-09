package com.stu74528.lab2_74528
// MainActivity.kt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.stu74528.lab2_74528.ui.theme.Lab2_74528Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2_74528Theme {
                // Create NavController
                val navController = rememberNavController()

                // Set up navigation
                AppNavigation()
            }
        }
    }
}


