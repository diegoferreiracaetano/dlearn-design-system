# AppEmptyState
Componente de estado vazio para exibir quando não há dados disponíveis.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | O título principal do estado vazio. |
| `description` | `String` | - | O texto de apoio ou instrução para o usuário. |
| `modifier` | `Modifier` | `Modifier` | Modificador para ajustes de layout. |
| `imageResource` | `DrawableResource?` | `null` | Recurso de imagem local. |
| `imageURL` | `String?` | `null` | URL da imagem remota. |

### Usage
```kotlin
AppEmptyState(
    title = "Nenhum filme encontrado",
    description = "Tente ajustar seus filtros de busca.",
    imageResource = Res.drawable.empty_search
)
```
