# AppSnackbarHost
Componente que gerencia a exibição de Snackbars customizados.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `hostState` | `SnackbarHostState` | - | Estado que controla a exibição do snackbar. |

### Usage
```kotlin
AppSnackbarHost(hostState = snackbarHostState)
```

---

# AppDialog
Um componente de diálogo de alerta personalizado seguindo as especificações do Material 3 e o estilo do projeto.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `onDismissRequest` | `() -> Unit` | - | Callback quando o diálogo é descartado. |
| `confirmButtonText` | `String` | - | O texto para o botão de confirmação. |
| `onConfirmClick` | `() -> Unit` | - | Callback para o botão de confirmação. |
| `modifier` | `Modifier` | `Modifier` | O [Modifier] a ser aplicado ao diálogo. |
| `dismissButtonText` | `String?` | `null` | Texto opcional para o botão de descarte. |
| `onDismissClick` | `(() -> Unit)?` | `null` | Callback opcional para o botão de descarte. |
| `title` | `String?` | `null` | Título opcional para o diálogo. |
| `description` | `String?` | `null` | Descrição opcional para o diálogo. |
| `imageSource` | `AppImageSource?` | `null` | [AppImageSource] opcional a ser exibido no topo. |

### Usage
```kotlin
AppDialog(
    onDismissRequest = { /* dismiss */ },
    title = "Are you sure ?",
    description = "Ullamcorper imperdiet urna id non sed est sem.",
    confirmButtonText = "Cancel",
    onConfirmClick = { /* confirm */ },
    dismissButtonText = "Log Out",
    onDismissClick = { /* logout */ }
)
```

---

# AppShareDialog
Um diálogo de compartilhamento que exibe uma lista de opções de redes sociais ou outras ações.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `onDismissRequest` | `() -> Unit` | - | Callback quando o diálogo é descartado. |
| `options` | `List<ShareOption>` | - | Lista de opções de compartilhamento a serem exibidas. |
| `onOptionClick` | `(ShareOption) -> Unit` | - | Callback quando uma opção de compartilhamento é clicada. |
| `modifier` | `Modifier` | `Modifier` | O [Modifier] a ser aplicado ao diálogo. |
| `title` | `String` | `"Share to"` | O título do diálogo. |

### ShareOption
| Atributo | Tipo | Descrição |
| :--- | :--- | :--- |
| `id` | `String` | Identificador único para a opção. |
| `icon` | `DrawableResource?` | Ícone opcional usando recurso drawable. |
| `imageVector` | `ImageVector?` | Ícone opcional usando ImageVector. |
| `backgroundColor` | `Color?` | Cor de fundo opcional para o container do ícone. |
| `backgroundBrush` | `Brush?` | Gradiente opcional para o container do ícone. |
| `iconTint` | `Color` | Cor para tingir o ícone (Padrão: White). |
| `contentDescription` | `String` | Descrição de acessibilidade. |

### Usage
```kotlin
AppShareDialog(
    onDismissRequest = { /* dismiss */ },
    onOptionClick = { option -> /* handle click */ },
    options = listOf(
        ShareOption(
            id = "facebook",
            imageVector = Icons.Default.Share,
            backgroundColor = Color(0xFF3b5998),
            contentDescription = "Facebook"
        )
    )
)
```
