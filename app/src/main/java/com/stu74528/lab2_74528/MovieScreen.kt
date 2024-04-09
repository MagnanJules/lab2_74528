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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(navController: NavController, movie: Movie) {
    var seatsReserved by remember { mutableStateOf(0) } // État pour le nombre de places réservées

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
            Text(
                text = movie.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp) // Ajouter un espacement en bas
            )
            Image(
                painter = painterResource(id = movie.image), // Utiliser l'ID de ressource de l'image du film
                contentDescription = "Movie Image",
                modifier = Modifier.size(420.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Description: ${movie.description}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Running Time: ${movie.runningTimeMins} mins",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Starring: ${movie.starring.joinToString(", ")}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Seats Remaining: ${movie.seatsRemaining }", // Utilisez la différence entre les sièges restants et les sièges réservés
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Seats Reserved: ${movie.seatsSelected}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            ReservationButtons(movie = movie, seatsReserved = seatsReserved,  navController) { increment ->
                seatsReserved += increment
            }
        }
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
