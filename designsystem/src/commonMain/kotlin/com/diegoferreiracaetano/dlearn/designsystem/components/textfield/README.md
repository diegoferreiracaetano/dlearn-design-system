### 1. Nome
`AppTextField`

### 2. Descrição
Componente de campo de texto customizado que suporta diferentes tipos (EMAIL, PASSWORD, NONE), validação de erro, ícones e texto de suporte (supporting text). Possui lógica integrada para alternar visibilidade de senhas.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `value` | `String` | - | O texto atual do campo. |
| `onValueChange` | `(String) -> Unit` | - | Callback chamado quando o texto muda. |
| `placeholder` | `StringResource` | - | Texto de dica exibido quando o campo está vazio. |
| `label` | `StringResource?` | `null` | Rótulo exibido acima ou dentro do campo. |
| `supportingText` | `StringResource?` | `null` | Texto de ajuda ou erro exibido abaixo do campo. |
| `isError` | `Boolean` | `false` | Se verdadeiro, destaca o campo com a cor de erro. |
| `type` | `TextFieldType` | `TextFieldType.NONE` | Define o comportamento e transformações (ex: máscara de senha). |
| `leadingIcon` | `@Composable (() -> Unit)?` | `null` | Ícone opcional no início do campo. |
| `shape` | `Shape` | `MaterialTheme.shapes.extraLarge` | Forma do contorno do campo. |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |

### 4. Exemplo de uso

```kotlin
var email by remember { mutableStateOf("") }

AppTextField(
    value = email,
    onValueChange = { email = it },
    placeholder = Res.string.placeholder_email,
    label = Res.string.label_email,
    type = TextFieldType.EMAIL,
    isError = email.isEmpty()
)
```
