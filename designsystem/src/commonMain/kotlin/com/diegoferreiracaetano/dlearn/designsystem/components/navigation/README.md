# Navigation Components

A collection of components to handle app-level navigation, including top bars, bottom bars, and root containers.

---

## AppContainer
A root container component that provides a common layout structure including a top bar, bottom bar, and navigation drawer. It automatically handles responsive drawer behavior and centralized loading/error states.

**Key Feature:** The `topBar` and `content` slots are wrapped in `AnimatedContent`, ensuring smooth crossfade transitions whenever their content changes (e.g., during screen navigation).

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `topBar` | `@Composable () -> Unit` | `null` | Slot for the top bar (Animated). |
| `searchBar` | `@Composable () -> Unit` | `null` | Slot for a search bar below the top bar. |
| `chipGroup` | `@Composable () -> Unit` | `null` | Slot for filter chips. |
| `bottomBar` | `@Composable () -> Unit` | `null` | Slot for the bottom navigation bar. |
| `isLoading` | `Boolean` | `false` | Displays a centered loading state if true. |
| `error` | `Throwable?` | `null` | Displays an error state if provided. |
| `content` | `@Composable (Modifier) -> Unit` | - | Main content area (Animated). |

### Usage
```kotlin
AppContainer(
    topBar = { AppTopBar(title = "Home") },
    bottomBar = { AppBottomNavigationBar(...) }
) { modifier ->
    HomeScreen(modifier)
}
```

---

## AppTopBar
A flexible top app bar that supports titles, subtitles, navigation icons, and actions. It can be configured using a `TopBarConfig` object.

### TopBarConfig
Used to configure the `AppTopBar` dynamically.
- `route`: Unique identifier used for automatic selection in lists.
- `title`, `subtitle`: Main and secondary text labels.
- `onBack`, `onMenuClick`, `onSearchClick`, `onFavorite`: Action callbacks.
- `useTransparent`, `backgroundColor`: Styling for overlay or immersive headers.
- `profileImageSource`, `onProfileClick`: User profile integration.

### List-based usage
You can provide a list of configurations that automatically syncs with a `selectedRoute`. This is ideal for main navigation where each tab has a different toolbar.

```kotlin
val configs = listOf(
    TopBarConfig(route = "home", title = "Home"),
    TopBarConfig(route = "search", title = "Search")
)

AppTopBar(
    configs = configs,
    selectedRoute = currentRoute
)
```

---

## AppBottomNavigationBar
A bottom navigation bar that follows the design system and adjusts for platform-specific safe areas (Android/iOS).

### AppNavigationTab
- `route`: Unique identifier.
- `label`: Display text.
- `selectedIcon` / `unselectedIcon`.
