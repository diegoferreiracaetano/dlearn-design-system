# AppEmptyState
Componente de estado vazio para exibir quando não há dados disponíveis.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | O título principal do estado vazio. |
| `description` | `String` | - | O texto de apoio ou instrução para o usuário. |
| `modifier` | `Modifier` | `Modifier` | Modificador para ajustes de layout. |
| `imageSource` | `AppImageSource?` | `null` | Fonte da imagem (URL ou Recurso). |

### Usage
```kotlin
AppEmptyState(
    title = "Nenhum filme encontrado",
    description = "Tente ajustar seus filtros de busca.",
    imageSource = AppImageSource.Resource(Res.drawable.empty_search)
)
```
