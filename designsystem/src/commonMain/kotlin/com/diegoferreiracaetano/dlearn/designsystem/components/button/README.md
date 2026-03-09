# Button Components

A collection of button components following the DLearn Design System.

## Components

### AppButton
The base button component supporting primary, secondary, and tertiary styles, with optional icons and localization support.

**Parameters:**
- `text`: `StringResource` or `String?` - The text to display.
- `onClick`: `() -> Unit` - Callback when clicked.
- `type`: `AppButtonType` - Style of the button.
- `imageSource`: `AppImageSource?` - Leading icon.
- `iconTint`: `Color?` - Optional tint for the icon.
- `enabled`: `Boolean` - Interaction state.
- `backgroundColor`: `Color?` - Background override.

---

### AppButtonComponent
A high-level wrapper that uses `AppButtonType` and `AppIconType` for easier consumption, especially in movie-related actions.

**Parameters:**
- `onClick`: `() -> Unit` - Callback.
- `text`: `String?` - Optional text.
- `buttonType`: `AppButtonType` - `PRIMARY`, `SECONDARY`, or `TERTIARY`.
- `icon`: `AppIconType?` - `PLAY_ARROW`, `DOWNLOAD`, or `SHARE`.
- `actionUrl`: `String?` - Deep link or action URL.

---

## Enums

### AppButtonType
- `PRIMARY`: Filled button (Main action).
- `SECONDARY`: Outlined or surface-variant button (Secondary action).
- `TERTIARY`: Minimal button (Less important actions).

### AppIconType
- `PLAY_ARROW`: Standard play icon.
- `DOWNLOAD`: Download icon (currently uses `folder` resource).
- `SHARE`: Share icon (currently uses `search` resource).

---

## Usage

### Simple Button
```kotlin
AppButton(
    text = "Click Me",
    onClick = { /* action */ }
)
```

### Movie Actions Style
```kotlin
AppButtonComponent(
    text = "Trailer",
    buttonType = AppButtonType.PRIMARY,
    icon = AppIconType.PLAY_ARROW,
    onClick = { /* play */ }
)
```
