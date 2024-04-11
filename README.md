# Mobile App Lab 2

**Author:** Magnan Jules  
**Student number:** 74528

- [Youtube Video](https://youtu.be/kwYhCckWG6Q)
- [GitHub Repository](https://github.com/MagnanJules/lab2_74528)

## Overview

For this project, I employed a navigation controller as taught in the course to ensure smooth transitions between different pages within the application. Utilizing routes facilitated this seamless transition, enhancing user experience. A pivotal aspect of the project involved the creation of a `Movie` class to encapsulate essential movie information. Additionally, to manage movie data persistence during page transitions, I developed a `MovieStore` class.

## Features

- Implemented a lazy list on the home page to efficiently present movie items.
- Each item displays the movie poster stored within the app, searchable by the image name (stored as an integer) in the `Movie` class.
- Prominently featured the movie title in large, bold font.
- Displayed the remaining seats and reserved seats in a medium-sized font.
- Implemented navigation to a Movie Screen when the user clicks on an item.
- On the Movie Screen, users can view information about the film such as its description, title, poster, the number of seats they have selected, and the number of remaining seats.
- Three buttons on the Movie Screen: Plus (to reserve a seat), Minus (to cancel the reservation of a seat), and Reserve (to confirm the desired number of seats).
- Return button at the top of the Movie Screen to navigate back to the home page.
- Reserve button redirects to the homepage where other films are listed.
- Organized the Movie Screen as a lazy list to maintain consistency in user experience.


