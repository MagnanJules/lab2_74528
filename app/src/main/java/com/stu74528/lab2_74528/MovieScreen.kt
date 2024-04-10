package com.stu74528.lab2_74528

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button

import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(navController: NavController, movie: Movie) {
    var seatsReserved by remember { mutableStateOf(0) } // State for the number of reserved seats

    LazyColumn(
        modifier = Modifier.padding(16.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        item {
            TopAppBar(
                title = { Text(text = "Movie Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(painter = painterResource(id = R.drawable.return_), contentDescription = "Go Home")
                    }
                },
                actions = {
                },
            )
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = movie.name,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),

                modifier = Modifier.padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .padding(vertical = 16.dp) // Add vertical padding for centering vertically
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = movie.image),
                contentDescription = "Movie Image",
                modifier = Modifier.size(420.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            MovieDetailsItem("Description", movie.description)
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            MovieDetailsItem("Running Time", "${movie.runningTimeMins} mins")
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            MovieDetailsItem("Starring", movie.starring.joinToString(", "))
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            MovieDetailsItem("Seats Remaining", "${movie.seatsRemaining}")
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            MovieDetailsItem("Seats Reserved", "${movie.seatsSelected}")
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(vertical = 8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            ReservationButtons(movie = movie, seatsReserved = seatsReserved, navController) { increment ->
                seatsReserved += increment
            }
        }
    }
}

@Composable
fun MovieDetailsItem(label: String, value: String) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = Color.Black // Change text color to black
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black // Change text color to black
        )
    }
}

@Composable
fun ReservationButtons(movie: Movie, seatsReserved: Int, navController: NavController,onSeatReserved: (Int) -> Unit ) {
    Column {
        Text(
            text = "Reservation",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            ReservationButton(text = "-", onClick = { onSeatReserved(-1)
                movie.seatsSelected-=1
                movie.seatsRemaining+=1
                MovieRepository.updateMovie(movie.name,  movie.seatsSelected, movie.seatsRemaining)
            })
            Spacer(modifier = Modifier.width(8.dp))
            ReservationButton(text = "+", onClick = { onSeatReserved(1)
                movie.seatsSelected+=1
                movie.seatsRemaining-=1
                MovieRepository.updateMovie(movie.name,  movie.seatsSelected, movie.seatsRemaining)
            })
            Spacer(modifier = Modifier.width(8.dp))
            ReservationButton(text = "Reserve") {
                // Naviguer vers l'écran d'accueil lorsque le bouton "Réserver" est cliqué
                navController.navigate(Routes.Home.route)
            }

        }
    }
}

@Composable
fun ReservationButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}
