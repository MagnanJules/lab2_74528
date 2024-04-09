package com.stu74528.lab2_74528

import androidx.lifecycle.ViewModel
import com.stu74528.lab2_74528.Movie
import kotlin.random.Random

object MovieRepository {
    var random = Random
    val movies = mutableListOf(
        Movie(
            name = "Demon Slayer",
            image = R.drawable.demonslayer,
            certification = "PG",
            description = "Kagaya Ubuyashiki, Head of the Demon Slayer Corps, visits a graveyard where the deceased Demon Slayer warriors are buried with the help of his wife Amane. Lamenting about those who gave their lives in the continuous war against demon king Muzan Kibutsuji and his army, he declares that the human spirit will always rise to the challenge",
            starring = arrayOf("Haruo Sotozaki"),
            runningTimeMins = 95,
            seatsRemaining = random.nextInt(1,15),
            seatsSelected = 0
        ),
        Movie(

            name = "Oppenheimer",
            image = R.drawable.oppenheimer,
            certification = "PG",
            description = "In 1926, the 22-year-old doctoral student J. Robert Oppenheimer grapples with anxiety and homesickness while studying experimental quantum physics under Patrick Blackett at the Cavendish Laboratory in the University of Cambridge. Upset with Blackett's attitude, Oppenheimer leaves him an apple poisoned with cyanide but later retrieves it. The visiting scientist Niels Bohr advises Oppenheimer to study theoretical physics at the University of Göttingen instead.",
            starring = arrayOf("Cillian Murphy", "Robert Downey Jr."),
            runningTimeMins = 95,
            seatsRemaining = random.nextInt(1,15),
            seatsSelected = 0
        ),
        Movie(
            name = "In The Mood For Love",
            image = R.drawable.inthemoodforlove,
            certification = "PG",
            description = "A dramatic love story with the best movie music and images.",
            starring = arrayOf("Tony Leung", "Maggie Cheung"),
            runningTimeMins = 98,
            seatsRemaining = random.nextInt(1,15),
            seatsSelected = 0
        ),
        Movie(
            name = "Spirited Away",
            image = R.drawable.chihiro,
            certification = "PG",
            description = "Ten-year-old Chihiro Ogino and her parents, Akio and Yūko, are traveling to their new home. Akio decides to take a shortcut and stops in front of a tunnel leading to what appears to be an abandoned amusement park, which Akio insists on exploring despite his daughter's protests. Upon finding a seemingly empty restaurant still stocked with food, Chihiro's parents immediately begin to eat. While exploring further, Chihiro reaches an enormous bathhouse and meets a boy named Haku, who warns her to return across the riverbed before sunset. However, Chihiro discovers her parents have turned into pigs, and she is unable to cross the now-flooded river.",
            starring = arrayOf("Miyazaki"),
            runningTimeMins = 125,
            seatsRemaining = random.nextInt(1,15),
            seatsSelected = 0
        ),
        // Ajoutez les autres films ici
    )
    fun updateMovie(movieName: String, seatsSelected: Int, seatsRemaining: Int) {
        val movie = movies.find { it.name == movieName }
        movie?.let {
            it.seatsSelected = seatsSelected
            it.seatsRemaining = seatsRemaining
        }
    }
}
