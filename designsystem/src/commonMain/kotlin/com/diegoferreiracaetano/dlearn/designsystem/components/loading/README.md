### 1. Nome
`AppLoading`, `ScreenLoading`

### 2. Descrição
Componentes de carregamento visual animado. `AppLoading` é um spinner rotativo simples, enquanto `ScreenLoading` fornece uma versão em tela cheia com fundo translúcido para bloquear interações durante processos de carga.

### 3. Tabela de Props (Parâmetros)

#### `AppLoading`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `color` | `Color` | `Color.Red` | Cor do arco de carregamento. |
| `strokeWidth` | `Float` | `20f` | Espessura da linha do arco. |

#### `ScreenLoading`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout. Ocupa a tela toda por padrão. |

### 4. Exemplo de uso

```kotlin
// Carregamento simples
AppLoading(color = Color.Blue)

// Carregamento em tela cheia
if (isLoading) {
    ScreenLoading()
}
```
