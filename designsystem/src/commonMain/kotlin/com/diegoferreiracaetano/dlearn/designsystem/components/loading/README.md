### 1. Nome
`AppLoading`

### 2. Descrição
Componente de carregamento visual animado (spinner) que utiliza uma animação de arco rotativo infinito, permitindo customização de cor e espessura do traço.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `color` | `Color` | `Color.Red` | Cor do arco de carregamento. |
| `strokeWidth` | `Float` | `20f` | Espessura da linha do arco. |

### 4. Exemplo de uso

```kotlin
AppLoading(
    color = MaterialTheme.colorScheme.primary,
    strokeWidth = 15f
)
```
