### 1. Nome
`AppSnackbarHost`

### 2. Descrição
Componente que gerencia a exibição de Snackbars customizados.

### 3. Tabela de Props (Parâmetros)

<a name="appsnackbarhost"></a>
#### `AppSnackbarHost`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `hostState` | `SnackbarHostState` | - | Estado que controla a exibição do snackbar. |

### 4. Exemplo de uso
```kotlin
AppSnackbarHost(hostState = snackbarHostState)
```

---

### 1. Nome
`AppDialog`

### 2. Descrição
Um componente de diálogo de alerta personalizado seguindo as especificações do Material 3 e o estilo do projeto.

### 3. Tabela de Props (Parâmetros)

<a name="appdialog"></a>
#### `AppDialog`
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
| `imageResource` | `DrawableResource?` | `null` | [DrawableResource] opcional a ser exibido no topo. |

### 4. Exemplo de uso
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
