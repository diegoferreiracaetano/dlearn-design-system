### 1. Nome
`AppBanner`

### 2. Descrição
Um componente de banner para exibir informações de destaque ou assinaturas.

### 3. Tabela de Props (Parâmetros)

<a name="appbanner"></a>
#### `AppBanner`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | O texto do título do banner. |
| `subtitle` | `String` | - | O texto do subtítulo ou descrição do banner. |
| `modifier` | `Modifier` | `Modifier` | O [Modifier] a ser aplicado ao banner. |
| `imageResource` | `DrawableResource?` | `null` | [DrawableResource] opcional a ser exibido como ícone principal. |
| `backgroundColor` | `Color?` | `null` | Cor de fundo opcional. O padrão é laranja (tertiary). |

### 4. Exemplo de uso
```kotlin
AppBanner(
    title = "Premium Member",
    subtitle = "New movies are coming for you, Download Now!",
    imageResource = Res.drawable.ic_premium
)
```
