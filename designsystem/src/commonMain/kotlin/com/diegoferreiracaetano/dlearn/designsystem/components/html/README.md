# AppHtmlText
Componente para renderizar textos com tags HTML básicas, utilizando a tipografia e cores do sistema de design.

### Tags Suportadas
- `<b>`, `<strong>`: Texto em negrito.
- `<i>`, `<em>`: Texto em itálico.
- `<u>`: Texto sublinhado.
- `<a>`: Links (coloridos com a cor primária e sublinhados).
- `<br>`: Quebra de linha.
- `<h1>`, `<h2>`, `<h3>`: Cabeçalhos com tamanhos pré-definidos.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `html` | `String` | - | String contendo o conteúdo HTML. |
| `modifier` | `Modifier` | `Modifier` | Modificador a ser aplicado ao componente. |
| `style` | `TextStyle` | `bodyMedium` | Estilo de texto base. |
| `color` | `Color` | `Unspecified` | Cor base do texto. |
| `linkColor` | `Color` | `primary` | Cor aplicada aos links (`<a>`). |

### Usage
```kotlin
AppHtmlText(
    html = "Aceito os <b>Termos de Uso</b> e a <a href='#'>Política de Privacidade</a>.<br>Versão 1.0",
    style = MaterialTheme.typography.bodyLarge
)
```
