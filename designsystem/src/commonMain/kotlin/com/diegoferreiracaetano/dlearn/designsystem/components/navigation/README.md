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
Barra superior versátil com suporte a estilos padrão e transparente, busca integrada e perfil de usuário.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String?` | `null` | Título central da barra. |
| `subtitle` | `String?` | `null` | Subtítulo exibido abaixo do título. |
| `onBack` | `(() -> Unit)?` | `null` | Callback para o ícone de voltar. |
| `onFavorite` | `(() -> Unit)?` | `null` | Callback para a ação de favoritar (modo transparente). |
| `onMenuClick` | `(() -> Unit)?` | `null` | Callback para o ícone de menu lateral. |
| `searchValue` | `String` | `""` | Valor atual do campo de busca. |
| `onSearchValueChange` | `((String) -> Unit)?` | `null` | Ativa a busca e recebe as mudanças de texto. |
| `useTransparent` | `Boolean` | `false` | Se verdadeiro, utiliza o estilo transparente. |
| `profileImageUrl` | `String?` | `null` | URL da imagem de perfil. |
| `profileImageResource` | `DrawableResource?` | `null` | Recurso local da imagem de perfil. |
| `onProfileClick` | `(() -> Unit)?` | `null` | Callback ao clicar na imagem de perfil. |

### Usage
```kotlin
// Barra padrão com perfil e busca
AppTopBar(
    title = "Explorar",
    subtitle = "Tendências de hoje",
    profileImageUrl = "https://...",
    onProfileClick = { /* Navegar para perfil */ },
    onSearchValueChange = { query -> /* Filtrar lista */ }
)

// Barra transparente para telas de detalhes
AppTopBar(
    useTransparent = true,
    backgroundColor = Color.Black,
    onBack = { /* Voltar */ },
    onFavorite = { /* Favoritar */ }
)
```
