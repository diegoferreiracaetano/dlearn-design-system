### 1. Nome
`AppList`

### 2. Descrição
Uma `LazyColumn` personalizada que suporta conteúdo colapsável (como um cabeçalho ou grupo de filtros) que desaparece ao rolar para baixo e reaparece ao rolar para cima.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `collapsibleContent` | `@Composable (() -> Unit)?` | `null` | Conteúdo opcional que colapsa durante a rolagem. |
| `content` | `LazyListScope.() -> Unit` | - | O conteúdo principal da lista, definido usando o escopo do `LazyColumn`. |

### 4. Exemplo de uso

```kotlin
AppList(
    collapsibleContent = {
        // Ex: Um grupo de chips ou cabeçalho
        Text("Cabeçalho Colapsável")
    }
) {
    items(100) { index ->
        Text("Item $index")
    }
}
```
