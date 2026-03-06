# AppList
Um componente de lista robusto baseado em `LazyColumn` que suporta um cabeçalho colapsável (Sticky Header).

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout. |
| `collapsibleContent` | `@Composable () -> Unit` | `null` | Cabeçalho que esconde ao rolar para baixo. |
| `content` | `LazyListScope.() -> Unit` | - | Itens da lista. |

### Usage
```kotlin
AppList(
    collapsibleContent = { AppBanner(title = "Bem-vindo!", description = "Confira as novidades.") }
) {
    items(myData) { item -> /* ... */ }
}
```

---

# AppProfileRow
Exibe informações de perfil do usuário com suporte a uma ação de edição.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `name` | `String` | - | Nome do usuário. |
| `email` | `String` | - | E-mail ou identificador. |
| `imageURL` | `String?` | `null` | URL para imagem remota. |
| `onEditClick` | `() -> Unit` | - | Callback para ação de edição. |

### Usage
```kotlin
AppProfileRow(
    name = "John Doe",
    email = "john.doe@email.com",
    onEditClick = { /* Abrir edição */ }
)
```

---

# AppTextRow
Uma linha flexível que exibe um rótulo e um valor opcional, com suporte a ícones e navegação.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `label` | `StringResource` | - | Rótulo principal. |
| `value` | `StringResource?` | `null` | Texto de apoio. |
| `leadingIcon` | `ImageVector?` | `null` | Ícone à esquerda. |
| `onClick` | `(() -> Unit)?` | `null` | Ação ao clicar (exibe seta de navegação). |

### Usage
```kotlin
AppTextRow(
    label = Res.string.language,
    value = Res.string.language_current,
    leadingIcon = Icons.Default.Language,
    onClick = { /* Abrir seleção */ }
)
```

---

# AppSectionTitle
Utilizado para agrupar linhas em seções lógicas com espaçamento e tipografia adequados.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `StringResource` | - | Texto do título da seção. |

### Usage
```kotlin
AppSectionTitle(title = Res.string.settings_general)
```
