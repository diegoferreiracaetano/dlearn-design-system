# Movie Components

Specialized UI components for displaying movie and series information, metadata, and actions.

## Components

### AppMovieActions
A vertical action bar typically used in movie detail screens. It includes the main play/trailer button and the watch providers section.

**Parameters:**
- `onPlayClick`: `() -> Unit` - Callback for the main play/trailer action.
- `providers`: `List<WatchProvider>` - List of streaming services where the movie is available.
- `onProviderClick`: `(WatchProvider) -> Unit` - Callback when a specific provider is selected.
- `modifier`: `Modifier` - Modifier for the container.
- `playText`: `String` - Label for the play button (default: "Trailer").
- `isPlaying`: `Boolean` - Whether the video is currently playing.

### AppWatchProviders
A component that shows where a movie can be watched. It supports a collapsed view with a summary and an expanded view with a detailed list and direct links.

**Parameters:**
- `providers`: `List<WatchProvider>` - Data objects for each streaming service.
- `onProviderClick`: `(WatchProvider) -> Unit` - Callback to handle navigation to the provider.
- `modifier`: `Modifier` - Modifier for the container.

### AppMovieDetailHeader
A header component that displays a movie poster or a video player along with metadata and actions.

**Parameters:**
- `movie`: `MovieItem` - Data object containing movie details.
- `providers`: `List<WatchProvider>` - List of available watch providers.
- `onProviderClick`: `(WatchProvider) -> Unit` - Callback for provider selection.
- `modifier`: `Modifier` - Modifier for the container.
- `onPlayClick`: `() -> Unit` - Callback when the play button is pressed.

## Usage

```kotlin
val providers = listOf(
    WatchProvider("Netflix", iconSource, "Subscription", "https://netflix.com/...")
)

AppMovieDetailHeader(
    movie = myMovieItem,
    providers = providers,
    onProviderClick = { provider -> /* Open URL */ },
    onPlayClick = { /* Handle play */ }
)
```
