# AppLoading
Componente de carregamento visual animado (spinner rotativo).

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `color` | `Color` | `Color.Red` | Cor do arco de carregamento. |
| `strokeWidth` | `Float` | `20f` | Espessura da linha do arco. |

### Usage
```kotlin
AppLoading(color = Color.Blue)
```

---

# ScreenLoading
Versão em tela cheia do carregamento com fundo translúcido para bloquear interações.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout. Ocupa a tela toda por padrão. |

### Usage
```kotlin
if (isLoading) {
    ScreenLoading()
}
```
