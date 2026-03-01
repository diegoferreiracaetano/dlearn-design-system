### 1. Nome
`AppButton`

### 2. Descrição
Componente de botão padrão do DLearn Design System, suportando diferentes estilos (Primary, Secondary, Tertiary), ícones e estados (habilitado/desabilitado).

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `text` | `String` | - | Texto exibido no botão. |
| `onClick` | `() -> Unit` | - | Ação executada ao clicar no botão. |
| `type` | `ButtonType` | `ButtonType.PRIMARY` | Estilo visual do botão (PRIMARY, SECONDARY, TERTIARY). |
| `image` | `DrawableResource?` | `null` | Ícone opcional exibido ao lado do texto. |
| `enabled` | `Boolean` | `true` | Define se o botão está ativo para interação. |

### 4. Exemplo de uso

```kotlin
AppButton(
    text = "Clique aqui",
    onClick = { /* ação */ },
    type = ButtonType.PRIMARY,
    image = Res.drawable.ic_check
)
```
