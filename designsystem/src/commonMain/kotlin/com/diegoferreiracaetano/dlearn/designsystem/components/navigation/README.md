# Navigation Components

A collection of components to handle app-level navigation, including top bars, bottom bars, and root containers.

## AppNavigationContainer
The primary container for apps using bottom navigation. it automatically links `AppNavigationTab` with its content and updates the `AppTopBar` based on the tab's configuration.

### Props
| Prop | Type | Default | Description |
| :--- | :--- | :--- | :--- |
| `pages` | `List<AppNavigationPage>` | - | List of pages defining the tabs and their respective content. |
| `selectedRoute` | `String` | - | The current active route. |
| `onTabSelected` | `(String) -> Unit` | - | Callback when a tab is clicked. |

### Usage
```kotlin
val pages = listOf(
    AppNavigationPage(
        tab = AppNavigationTab(
            route = "home",
            label = "Home",
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Outlined.Home,
            topBarConfig = TopBarConfig(title = "DLearn", onSearchClick = { /* ... */ })
        ),
        content = { modifier -> HomeScreen(modifier) }
    )
)

AppNavigationContainer(
    pages = pages,
    selectedRoute = currentRoute,
    onTabSelected = { currentRoute = it }
)
```

---

## AppContainer
A low-level scaffold component that organizes `TopBar`, `SearchBar`, `ChipGroup`, and main content. It handles loading and error states while keeping navigation elements visible.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `topBar` | `@Composable () -> Unit` | `null` | Slot for the top bar. |
| `searchBar` | `@Composable () -> Unit` | `null` | Slot for a search bar below the top bar. |
| `chipGroup` | `@Composable () -> Unit` | `null` | Slot for filter chips. |
| `bottomBar` | `@Composable () -> Unit` | `null` | Slot for the bottom navigation bar. |
| `isLoading` | `Boolean` | `false` | Displays a centered loading state if true. |
| `error` | `Throwable?` | `null` | Displays an error state if provided. |

---

## AppTopBar
A flexible top app bar that supports titles, subtitles, navigation icons (back/menu), and actions.

### TopBarConfig
Used to configure the `AppTopBar` dynamically.
- `title`, `subtitle`
- `onBack`, `onMenuClick`, `onSearchClick`, `onFavorite`
- `useTransparent`, `backgroundColor`
- `profileImageSource`, `onProfileClick`

---

## AppBottomNavigationBar
A bottom navigation bar that follows the design system and adjusts for platform-specific safe areas (Android/iOS).

### AppNavigationTab
- `route`: Unique identifier.
- `label`: Display text.
- `selectedIcon` / `unselectedIcon`.
- `topBarConfig`: Dynamic configuration for the TopBar when this tab is active.
