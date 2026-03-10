# Video Components

A collection of components for media playback within the design system.

## Components

### AppYoutubePlayer
A specialized component to play YouTube videos using a platform-specific WebView implementation.

**Parameters:**
- `videoId`: `String` - The unique YouTube video identifier (e.g., "dQw4w9WgXcQ").
- `modifier`: `Modifier` - Applied to the player container.

**Platform Implementations:**
- **Android**: Uses `android.webkit.WebView`.
- **iOS**: Uses `WebKit.WKWebView`.
- **JVM (Desktop)**: Displays a placeholder (WebView support varies by environment).

## Usage

```kotlin
AppYoutubePlayer(
    videoId = "dQw4w9WgXcQ",
    modifier = Modifier.fillMaxWidth().aspectRatio(16/9f)
)
```

## Testing
Basic validation tests ensure that the video ID passed is valid. Platform-specific UI tests should verify that the WebView is correctly instantiated.
