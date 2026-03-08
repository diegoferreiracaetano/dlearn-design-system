# Movie Components

A collection of specialized components for displaying movies, series, and related metadata. These components are designed to be modular, following the Single Responsibility Principle.

## Components

### AppMovieItem
The main orchestrator component for lists and grids. It combines `AppMoviePoster` and `AppMovieInfo` into a cohesive layout.

**Parameters:**
- `movie`: `MovieItem` - The data model containing all movie information.
- `onClick`: `() -> Unit` - Callback for when the item is clicked.
- `type`: `MovieItemType` - Choose between `HORIZONTAL` (lists) or `VERTICAL` (grids/carousels).

---

### AppMovieDetailHeader
The top-level component for the movie detail screen. It orchestrates the Title, Poster, and detailed metadata.

**Parameters:**
- `movie`: `MovieItem` - The data model.
- `modifier`: `Modifier` - Applied to the root container.

---

### AppMoviePoster
Handles the visual representation of the movie, including the image and overlay badges.

**Parameters:**
- `imageSource`: `AppImageSource` - Source for the poster image.
- `rating`: `Double?` - Movie rating (displayed in a `RATING` badge).
- `width` / `height`: `Dp` - Dimensions of the poster.
- `primaryInfo` / `secondaryInfo`: `String?` - Optional text for informational badges overlaying the bottom.

---

### AppMovieInfo
Displays textual details and metadata for general listings. Adapts its density based on the layout orientation.

**Parameters:**
- `title`, `year`, `duration`, `contentRating`, `genre`, `type`: `String` - Movie metadata.
- `isPremium`: `Boolean` - Displays a "Premium" or "Free" tag.
- `layoutType`: `AppMovieInfoType` - `HORIZONTAL` or `VERTICAL`.

---

### AppMovieDetailInfo
A specialized metadata component for detail screens, featuring vertical dividers and a rating badge.

**Parameters:**
- `year`, `duration`, `genre`: `String` - Metadata.
- `rating`: `Double?` - Numeric rating.

---

## Usage

### Movie Detail Screen Header
```kotlin
AppMovieDetailHeader(
    movie = movieItem,
    modifier = Modifier.padding(16.dp)
)
```

### Listing Item
```kotlin
// Horizontal Layout
AppMovieItem(
    movie = movie,
    onClick = { /* Navigate */ },
    type = MovieItemType.HORIZONTAL
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
