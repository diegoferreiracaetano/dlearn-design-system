# AppBadge

A flexible and unified badge component used throughout the design system to display ratings, tags, and small metadata.

## Types

The `AppBadge` supports three main types via the `AppBadgeType` enum:

1.  **RATING**: Used for displaying ratings (e.g., "4.5"). Defaults to a semi-transparent black background and a Star icon.
2.  **TAG**: Used for categories or status (e.g., "Premium", "Free"). Fully customizable background and content colors.
3.  **OUTLINE**: Used for content ratings or secondary metadata (e.g., "PG-13"). Displays text inside a thin border.

## Usage

### Rating Badge
```kotlin
AppBadge(
    text = "4.5",
    type = AppBadgeType.RATING
)
```

### Tag Badge
```kotlin
AppBadge(
    text = "Premium",
    type = AppBadgeType.TAG,
    containerColor = MaterialTheme.colorScheme.tertiary
)
```

### Outline Badge
```kotlin
AppBadge(
    text = "PG-13",
    type = AppBadgeType.OUTLINE
)
```

## Parameters

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `text` | `String` | The text to display inside the badge. |
| `type` | `AppBadgeType` | Determines the badge's style (RATING, TAG, OUTLINE). |
| `modifier` | `Modifier` | Layout modifier. |
| `icon` | `ImageVector?` | Optional icon. Defaults to Star if type is RATING. |
| `containerColor` | `Color?` | Optional background color override. |
| `contentColor` | `Color?` | Optional content (text/icon) color override. |
