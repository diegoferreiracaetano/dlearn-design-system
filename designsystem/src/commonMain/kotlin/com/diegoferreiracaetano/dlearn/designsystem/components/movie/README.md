# Movie Components

Specialized UI components for displaying movie and series information, metadata, and actions.

## Components

### AppMovieActions
A horizontal action bar typically used in movie detail screens.

**Parameters:**
- `onPlayClick`: `() -> Unit` - Callback for the main play/trailer action.
- `onDownloadClick`: `() -> Unit` - Callback for the download action.
- `onShareClick`: `() -> Unit` - Callback for the share action.
- `modifier`: `Modifier` - Modifier for the container.
- `playText`: `String` - Label for the play button (default: "Trailer").
- `isPlaying`: `Boolean` - Whether the video is currently playing (toggles icon and text).

### AppMovieDetailHeader
A header component that displays a movie poster or a video player along with metadata.

**Parameters:**
- `movie`: `MovieItem` - Data object containing movie details.
- `modifier`: `Modifier` - Modifier for the container.
- `onPlayClick`: `() -> Unit` - Callback when the play button is pressed.
- `onDownloadClick`: `() -> Unit` - Callback for the download action.
- `onShareClick`: `() -> Unit` - Callback for the share action.

## Usage

```kotlin
AppMovieDetailHeader(
    movie = myMovieItem,
    onPlayClick = { /* Handle play */ }
)
```
