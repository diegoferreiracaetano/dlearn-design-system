# List Components

This package contains components used for building lists, settings screens, and profile sections.

## Components

### AppSectionTitle

A text component used as a header for sections in lists or carousels. It follows the design system's typography and spacing guidelines.

**Features:**
- Uses `MaterialTheme.typography.titleMedium` with `FontWeight.Bold`.
- Consistent padding (32dp top, 8dp bottom).
- Supports both `String` and `StringResource`.

**Usage:**

```kotlin
// Using StringResource
AppSectionTitle(title = Res.string.settings_section)

// Using raw String
AppSectionTitle(title = "Account Details")
```

### AppList

A high-level component that manages a `LazyColumn` with support for:
- Collapsible headers (hides on scroll down, shows on scroll up).
- Predefined item types: `ProfileHeaderItem`, `BannerItem`, `SectionTitleItem`, `TextRowItem`, etc.
- Custom composable items.

**Usage:**

```kotlin
val items = listOf(
    SectionTitleItem(title = Res.string.profile_title),
    ProfileHeaderItem(name = "User", email = "user@example.com"),
    SectionTitleItem(title = Res.string.settings_title),
    TextRowItem(label = Res.string.notifications, onCheckedChange = { ... })
)

AppList(items = items)
```

### AppTextRow

A row component for settings or menus with a label and optional trailing value or switch.

---
*Maintained by the Design System Team*
