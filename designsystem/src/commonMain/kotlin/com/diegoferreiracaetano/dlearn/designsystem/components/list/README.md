### 1. Nome
AppList

### 2. Descrição
Uma LazyColumn personalizada que suporta conteúdo colapsável.

### 3. Tabela de Props (Parâmetros)

#### AppList
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `collapsibleContent` | `@Composable (() -> Unit)?` | `null` | Conteúdo opcional que colapsa durante a rolagem. |

### 4. Exemplo de uso
```kotlin
AppList {
    items(10) { Text("Item $it") }
}
```
