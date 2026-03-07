# Carousel Components

A collection of horizontal scrolling components for different types of content, from banners to movie lists. All components are built upon a unified `AppCarousel` core.

---

## AppCarousel (Core)

The base generic carousel component that supports both paging (one item at a time) and standard horizontal scrolling (list of items).

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `itemCount` | `Int` | - | The total number of items in the carousel. |
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the container. |
| `title` | `String?` | `null` | Optional title displayed above the carousel. |
| `isPager` | `Boolean` | `true` | If true, uses a `HorizontalPager` for snapping. If false, uses a `LazyRow`. |
| `spacing` | `Dp` | `0.dp` / `8.dp` | The spacing between items. |
| `contentPadding` | `PaddingValues` | `0.dp` | The padding applied around the content. |
| `pagerState` | `PagerState` | `rememberPagerState` | The state for the pager (if `isPager` is true). |
| `showIndicator` | `Boolean` | `isPager` | If true, shows a page indicator. |
| `itemContent` | `Composable (Int) -> Unit` | - | The composable content for each item. |

---

## AppMovieCarousel

A specialized carousel for displaying movies or series using `AppMovieItem`. It uses standard horizontal scrolling (`isPager = false`).

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the container. |
| `title` | `String` | - | The title of the carousel section. |
| `items` | `List<MovieItem>` | - | The list of movie data to display. |
| `onMovieClick` | `(MovieItem) -> Unit` | `{}` | Callback triggered when a movie item is clicked. |

### Usage
```kotlin
AppMovieCarousel(
    title = "Trending Now",
    items = movieList,
    onMovieClick = { movie -> /* Navigate */ }
)
```

---

## AppBannerCarousel
Standard horizontal carousel for promotional highlights. It uses paging behavior (`isPager = true`).

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the container. |
| `title` | `String` | - | Title of the carousel section. |
| `itemCount` | `Int` | - | Total number of items. |
| `itemContent` | `Composable (Int) -> Unit` | - | Content for each page (usually `BannerCard`). |

### Usage
```kotlin
AppBannerCarousel(
    title = "Highlights",
    itemCount = items.size
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

## AppContinueWatchingCarousel
Horizontal list for displaying the progress of ongoing content. It uses standard horizontal scrolling (`isPager = false`).

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | The modifier to be applied to the container. |
| `title` | `String` | - | Title of the section (e.g., "Continue Watching"). |
| `itemCount` | `Int` | - | Number of items in the list. |
| `itemContent` | `Composable (Int) -> Unit` | - | Renderer for each item (usually `ContinueWatchingCard`). |

### Usage
```kotlin
AppContinueWatchingCarousel(
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

---

## FullScreenBanner
Pager component for full-screen banner display, ideal for the top of home or detail screens.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Total number of banners. |
| `pageContent` | `Composable (Int) -> Unit` | - | Content for each page (usually `FullScreenVideo`). |

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
