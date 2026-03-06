# AppContainer
Scaffold base que organiza automaticamente a TopBar, BottomBar e o conteúdo da tela.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `topBar` | `@Composable () -> Unit` | `null` | Slot para a barra superior. |
| `bottomBar` | `@Composable () -> Unit` | `null` | Slot para a barra inferior. |

### Usage
```kotlin
AppContainer(
    topBar = { AppTopBar(title = "Home") },
    bottomBar = { AppBottomNavigationBar(...) }
) { padding ->
    // Conteúdo aqui
}
```

---

# AppBottomNavigationBar
Barra de navegação inferior que se adapta visualmente para Android e iOS.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `items` | `List<AppNavigationTab>` | - | Lista de ícones e destinos. |

### Usage
```kotlin
AppBottomNavigationBar(items = tabs, selectedRoute = currentRoute)
```

---

# AppTopBar
Barra superior padrão com suporte a título e ações.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título central da barra. |

### Usage
```kotlin
AppTopBar(title = "Configurações")
```
