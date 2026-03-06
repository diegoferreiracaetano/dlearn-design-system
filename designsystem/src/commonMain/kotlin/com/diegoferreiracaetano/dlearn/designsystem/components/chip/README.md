# AppChipGroup
Componente que exibe um grupo de chips (filtros) horizontais roláveis.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `items` | `List<AppChip>` | - | Lista de chips a serem exibidos. |

### Usage
```kotlin
AppChipGroup(
    items = listOf(
        AppChip(label = "Séries", onClick = { /* filtro */ }),
        AppChip(label = "Filmes", onClick = { /* filtro */ })
    )
)
```
