# AppChip & AppChipGroup

Componentes para exibição de chips individuais ou grupos de chips (filtros).

## AppChip
Componente individual de chip seguindo as diretrizes do Design System.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador para o componente. |
| `label` | `String` | - | Texto exibido no chip. |
| `isSelected` | `Boolean` | `false` | Define se o chip está no estado selecionado. |
| `hasDropDown` | `Boolean` | `false` | Se verdadeiro, exibe um ícone de dropdown. |
| `onClick` | `() -> Unit` | - | Callback de clique. |

## AppChipGroup
Componente que exibe um grupo de chips horizontais roláveis com lógica de filtro integrada.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador para o componente. |
| `items` | `List<AppChipItem>` | - | Lista de itens (data class) a serem exibidos. |
| `onFilterChanged` | `(String?) -> Unit` | - | Callback invocado quando o filtro selecionado muda. |

### Data Class AppChipItem
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `label` | `String` | - | Texto do chip. |
| `onClick` | `() -> Unit` | `{}` | Ação extra ao clicar. |
| `hasDropDown` | `Boolean` | `false` | Exibe ícone de dropdown. |
| `isFilter` | `Boolean` | `true` | Se o chip participa da lógica de filtro exclusivo. |
| `isSelected` | `Boolean` | `false` | Estado inicial de seleção. |

### Usage
```kotlin
// Uso do Grupo de Chips
AppChipGroup(
    items = listOf(
        AppChipItem(label = "Séries"),
        AppChipItem(label = "Filmes")
    ),
    onFilterChanged = { label -> /* Handle filter */ }
)

// Uso do Chip Individual
AppChip(
    label = "Categoria",
    isSelected = true,
    onClick = { /* Action */ }
)
```
