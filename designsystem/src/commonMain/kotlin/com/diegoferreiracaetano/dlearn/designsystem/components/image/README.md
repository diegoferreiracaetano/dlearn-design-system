### 1. Nome
`AppImage`

### 2. Descrição
Componente de imagem versátil que suporta o carregamento de imagens via URL (usando Seiko Image Loader), recursos locais (`DrawableResource`) ou uma imagem padrão (banner) caso nenhuma seja fornecida.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. Inclui um tamanho padrão de 120.dp. |
| `imageURL` | `String?` | `null` | URL da imagem remota a ser carregada. |
| `imageResource` | `DrawableResource?` | `null` | Recurso de imagem local do projeto. |
| `contentDescription` | `String?` | `null` | Descrição de acessibilidade para a imagem. |

### 4. Exemplo de uso

```kotlin
// Usando URL
AppImage(
    imageURL = "https://exemplo.com/foto.jpg",
    contentDescription = "Foto de perfil"
)

// Usando recurso local
AppImage(
    imageResource = Res.drawable.meu_icone
)
```
