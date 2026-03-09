# Profile Components

This package contains components related to user profiles and lists. All components support both `String` and `StringResource` for localized content.

## Components

### AppUserRow
A user row component typically used in lists or carousels to display name and role/description. It includes a circular profile image, name, and role.

#### Usage
```kotlin
AppUserRow(
    name = "Jon Watts",
    role = "Directors",
    imageSource = AppImageSource.Resource(Res.drawable.profile),
    onClick = { /* Handle click */ }
)
```

---

### AppProfileRow
A profile row component that displays user information with an image and an edit button. It is designed to be used in profile settings or lists.

#### Usage
```kotlin
AppProfileRow(
    name = "John Doe",
    email = "john.doe@example.com",
    onEditClick = { /* Handle edit */ }
)
```

---

### AppProfileHeader
A profile header component that displays a large circular image with an edit button, followed by the user's name and email centered. It supports image picking via a dialog.

#### Usage
```kotlin
AppProfileHeader(
    name = "Tiffany",
    email = "tiffany@example.com",
    onImagePicked = { bytes -> /* Handle new image */ }
)
```
