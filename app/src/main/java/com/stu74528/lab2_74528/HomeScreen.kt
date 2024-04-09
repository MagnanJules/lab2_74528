package com.stu74528.lab2_74528

// HomeScreen.kt

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.window.layout.WindowMetrics

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val movies = MovieRepository.movies
    /*TopAppBar(
        title = { Text(text = "Movie Details") },

        )

    Spacer(modifier = Modifier.width(16.dp))*/
    LazyColumn(

        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(movies) { movie ->
            MovieItem(navController = navController, movie = movie)
        }
    }
}
@Composable
fun MovieItem(navController: NavController, movie: Movie) {
    Box(
        modifier = Modifier
            .clickable {
                navController.navigate("${Routes.Movie.route}/${movie.name}")
            }
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Color.Gray, shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = movie.image),
                contentDescription = "Movie Image",
                modifier = Modifier.size(360.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = movie.name, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                Text(text = "Seats Remaining: ${movie.seatsRemaining}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Seats Selected: ${movie.seatsSelected}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

