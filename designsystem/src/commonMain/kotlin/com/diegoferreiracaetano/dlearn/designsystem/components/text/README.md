# Text Components

A collection of enhanced text components for the DLearn design system.

## Components

### AppExpandableText
A text component that truncates long content based on a configurable `maxLines` and provides a "More" link to expand the full content.

**Parameters:**
- `text`: `String` - The full text to be displayed.
- `modifier`: `Modifier` - Applied to the root container.
- `maxLines`: `Int` - The maximum number of lines to show when collapsed (default: 3).
- `expandText`: `StringResource` - The localized resource for the expansion link (default: `Res.string.action_more`).
- `expandTextColor`: `Color` - The color of the "More" link (default: `MaterialTheme.colorScheme.primary`).
- `textAlign`: `TextAlign` - The alignment of the text (default: `TextAlign.Start`).
- `testTag`: `String` - Tag for instrumented tests (default: `AppExpandableTextTags.TEXT_CONTAINER`).

**Testing:**
Uses `AppExpandableTextTags` for instrumented tests:
- `TEXT_CONTAINER`: The root box containing the text.

## Usage

```kotlin
AppExpandableText(
    text = "For the first time in the cinematic history of Spider-Man, our friendly neighborhood hero's identity is revealed, bringing his Super Hero responsibilities into conflict with his normal life and putting those he cares about most at risk.",
    maxLines = 3
)
```
