package com.stu74528.lab2_74528

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.stu74528.lab2_74528.ui.theme.Lab2_74528Theme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Routes.Movie.route + "/{movieName}",
            arguments = listOf(navArgument("movieName") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieName = backStackEntry.arguments?.getString("movieName")
            if (!movieName.isNullOrBlank()) {
                val movie = getMovieByName(movieName)
                movie?.let { movie ->
                    MovieScreen(navController = navController, movie = movie)
                }
            }
        }
    }
}

fun getMovieByName(movieName: String): Movie? {
    // Recherchez le film par son nom dans votre liste de films et retournez-le
    // Remarque : Ceci est un exemple, vous devrez implémenter votre propre logique de recherche de film
    val movies = MovieRepository.movies

    return movies.find { it.name == movieName }
}
