# Movie Components

A collection of specialized components for displaying movies, series, and related metadata. These components are designed to be modular, following the Single Responsibility Principle.

## Components

### AppMovieItem
The main orchestrator component. It combines `AppMoviePoster` and `AppMovieInfo` into a cohesive layout. It supports both horizontal (list) and vertical (grid/carousel) layouts.

**Parameters:**
- `movie`: `MovieItem` - The data model containing all movie information.
- `onClick`: `() -> Unit` - Callback for when the item is clicked.
- `type`: `MovieItemType` - Choose between `HORIZONTAL` (lists) or `VERTICAL` (grids/carousels).

**Note:** In `VERTICAL` mode, if `movie.rank` is provided, the component renders a "Top 10" style item with a large rank number.

---

### AppMoviePoster
Handles the visual representation of the movie, including the image and overlay badges.

**Parameters:**
- `imageSource`: `AppImageSource` - Source for the poster image.
- `rating`: `Double` - Movie rating (displayed in a `RATING` badge).
- `width` / `height`: `Dp` - Dimensions of the poster.
- `primaryInfo` / `secondaryInfo`: `String?` - Optional text for informational badges overlaying the bottom of the poster.

---

### AppMovieInfo
Displays textual details and metadata. Adapts its density based on the layout orientation.

**Parameters:**
- `title`, `year`, `duration`, `contentRating`, `genre`, `type`: `String` - Movie metadata.
- `isPremium`: `Boolean` - Determines if a "Premium" or "Free" tag is shown.
- `isVerticalLayout`: `Boolean` - Adjusts the information density for vertical vs horizontal layouts.

---

## Usage

```kotlin
val movie = MovieItem(
    id = "1",
    title = "Spider-Man No Way Home",
    imageSource = AppImageSource.Resource(Res.drawable.poster),
    rating = 4.5,
    year = "2021",
    duration = "148 min",
    contentRating = "PG-13",
    genre = "Action",
    type = "Movie",
    isPremium = true
)

// Horizontal Layout (Standard list item)
AppMovieItem(
    movie = movie,
    onClick = { /* Navigate */ },
    type = MovieItemType.HORIZONTAL
)

// Vertical Layout (Grid or Carousel)
AppMovieItem(
    movie = movie,
    onClick = { /* Navigate */ },
    type = MovieItemType.VERTICAL
)
```

## Data Model
The components use a shared `MovieItem` data class:
```kotlin
data class MovieItem(
    val id: String,
    val title: String,
    val imageSource: AppImageSource,
    val rating: Double,
    val year: String,
    val duration: String,
    val contentRating: String,
    val genre: String,
    val type: String,
    val isPremium: Boolean,
    val primaryInfo: String? = null,
    val secondaryInfo: String? = null,
    val rank: Int? = null
)
```
