### 1. Nome
`AppChipGroup`

### 2. Descrição
Componente que exibe um grupo de chips (filtros) em uma linha horizontal rolável, permitindo a seleção de um filtro e a exibição de ícones de dropdown ou fechamento.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `items` | `List<AppChip>` | - | Lista de objetos `AppChip` a serem exibidos. |
| `onFilterChanged` | `(String?) -> Unit` | - | Callback acionado quando o filtro selecionado muda. |

#### Data Class `AppChip`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `label` | `String` | - | Texto exibido no chip. |
| `onClick` | `() -> Unit` | `{}` | Ação ao clicar no chip. |
| `hasDropDown` | `Boolean` | `false` | Se exibe um ícone de seta para baixo. |
| `isFilter` | `Boolean` | `true` | Se o chip se comporta como um filtro selecionável. |

### 4. Exemplo de uso

```kotlin
val chips = listOf(
    AppChip(label = "Séries"),
    AppChip(label = "Filmes"),
    AppChip(label = "Categorias", hasDropDown = true, isFilter = false)
)

AppChipGroup(
    items = chips,
    onFilterChanged = { selectedLabel ->
        // Lógica de filtro
    }
)
```
