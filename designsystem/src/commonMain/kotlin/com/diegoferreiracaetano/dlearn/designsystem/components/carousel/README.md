# Carousel Components

A collection of horizontal scrolling components for different types of content, from banners to movie lists.

---

## Carousel (Movie Carousel)

A standardized carousel for displaying movies or series using `AppMovieItem`. It automatically supports both ranked (Top 10) and unranked displays based on the `rank` property of `MovieItem`.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | The title of the carousel section. |
| `items` | `List<MovieItem>` | - | The list of movie data to display. |
| `onMovieClick` | `(MovieItem) -> Unit` | `{}` | Callback triggered when a movie item is clicked. |

### Usage
```kotlin
Carousel(
    title = "Trending Now",
    items = movieList,
    onMovieClick = { movie -> /* Navigate */ }
)
```

---

## BannerCarousel
Standard horizontal carousel for `BannerCard` items. Used for informational or promotional highlights.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Title of the carousel section. |
| `pageCount` | `Int` | - | Total number of pages. |
| `pageContent` | `Composable (Int) -> Unit` | - | Content for each page (usually `BannerCard`). |

### Usage
```kotlin
BannerCarousel(
    title = "Highlights",
    pageCount = items.size
) { index ->
    BannerCard(
        title = items[index].title,
        subtitle = items[index].subtitle,
        imageSource = AppImageSource.Url(items[index].url),
        onClick = { /* navigate */ }
    )
}
```

---

## FullScreenBanner
Pager component for full-screen banner display, ideal for the top of home or detail screens.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Total number of banners. |
| `pageContent` | `Composable (Int) -> Unit` | - | Content for each page (usually `FullScreenVideo`). |

### Usage
```kotlin
FullScreenBanner(
    pageCount = items.size
) { index ->
    FullScreenVideo(
        title = items[index].title,
        subtitle = items[index].subtitle,
        imageSource = AppImageSource.Url(items[index].thumbnailUrl),
        onItemClick = { /* navigate */ },
        onWatchClick = { /* watch */ },
        onAddToListClick = { /* add */ }
    )
}
```

---

## PageCarousel
Specialized carousel for Onboarding flows. Features a floating info card and an action button.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Total number of pages. |
| `onFinish` | `() -> Unit` | - | Callback triggered when clicking the button on the last page. |
| `imageContent` | `Composable (Int) -> Unit` | - | Background image for each page. |
| `infoContent` | `Composable (Int) -> Unit` | - | Textual/informative content for each page. |

### Usage
```kotlin
PageCarousel(
    pageCount = 3,
    onFinish = { /* navigate */ },
    imageContent = { index -> /* Image */ },
    infoContent = { index -> /* Text */ }
)
```

---

## ContinueWatchingCarousel
Horizontal list (LazyRow) for displaying the progress of ongoing content.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Title of the section (e.g., "Continue Watching"). |
| `itemCount` | `Int` | - | Number of items in the list. |
| `itemContent` | `Composable (Int) -> Unit` | - | Renderer for each item. |

### Usage
```kotlin
ContinueWatchingCarousel(
    title = "Continue Watching",
    itemCount = items.size
) { index ->
    ContinueWatchingCard(
        title = items[index].title,
        imageSource = AppImageSource.Url(items[index].url),
        onClick = { /* navigate */ }
    )
}
```
