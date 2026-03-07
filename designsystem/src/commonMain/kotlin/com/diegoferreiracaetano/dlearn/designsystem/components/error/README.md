# Error State System

This package provides a standardized and platform-aware error handling UI system for the DLearn Design System.

## Components

### `AppErrorState`
A full-screen component that displays an error message based on the current context (HTTP status code or network connectivity).

**Features:**
- **Context Awareness:** Automatically detects if the network is down and shows a "No Internet" state.
- **HTTP Mapping:** Maps common status codes (401, 404, 5xx) to specific user-friendly messages and illustrations.
- **Actions:** Supports "Retry" and "Close" actions with customizable callbacks.
- **Portuguese Support:** All strings are localized in Portuguese (PT-BR).

### `AppErrorFactory`
A central factory that logicizes the mapping from technical errors to UI models.

### `AppError` (Model)
An interface and a set of data classes representing different error states:
- `NoInternetError`
- `NotFoundError`
- `AuthError`
- `ServerError`
- `GenericError`

## Usage

```kotlin
AppErrorState(
    statusCode = 404, // Optional: Passing null defaults to a generic or connectivity error
    onRetry = { 
        // Logic to reload data
    },
    onClose = { 
        // Logic to dismiss the screen
    }
)
```

## Testing
The factory logic is covered by unit tests in `commonTest`. 
UI components can be previewed using Compose Previews provided in the file.
