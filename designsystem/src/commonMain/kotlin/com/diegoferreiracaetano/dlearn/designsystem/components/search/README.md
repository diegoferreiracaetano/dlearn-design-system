# AppSearchBar
Barra de busca baseada no Material 3 SearchBar, com suporte a estados ativo/inativo e sugestões.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `query` | `String` | - | O valor atual da busca. |
| `onQueryChange` | `(String) -> Unit` | - | Callback invocado quando o texto muda. |
| `onSearch` | `(String) -> Unit` | - | Callback invocado ao disparar a busca (ex: botão de busca do teclado). |
| `active` | `Boolean` | - | Controla se a barra de busca está expandida (ativa). |
| `onActiveChange` | `(Boolean) -> Unit` | - | Callback invocado quando o estado ativo muda. |
| `placeholder` | `String` | `Res.string.search_placeholder` | Texto exibido quando o campo está vazio. |
| `content` | `@Composable ColumnScope.() -> Unit` | `{}` | Conteúdo exibido quando a barra está ativa (sugestões, histórico). |

### Usage
```kotlin
var query by remember { mutableStateOf("") }
var active by remember { mutableStateOf(false) }

AppSearchBar(
    query = query,
    onQueryChange = { query = it },
    onSearch = { active = false },
    active = active,
    onActiveChange = { active = it }
) {
    // Sugestões ou histórico de busca aqui
}
```
