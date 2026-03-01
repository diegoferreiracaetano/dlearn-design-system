### 1. Nome
`BannerCarousel`

### 2. Descrição
Componente de carrossel de banners que utiliza um `HorizontalPager` para alternar entre diferentes conteúdos de página (geralmente `BannerCard`), incluindo um indicador de página (`PageIndicator`).

### 3. Tabela de Props (Parâmetros)

#### `BannerCarousel`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `title` | `String` | - | Título da seção do carrossel. |
| `pageCount` | `Int` | - | Número total de páginas no carrossel. |
| `pageContent` | `@Composable (Int) -> Unit` | - | Conteúdo de cada página, recebe o índice da página. |

#### `BannerCard`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título exibido no card. |
| `subtitle` | `String` | - | Subtítulo exibido no card. |
| `imageUrl` | `String?` | `null` | URL da imagem de fundo. |
| `imageResource` | `DrawableResource?` | `null` | Recurso de imagem local. |
| `onClick` | `() -> Unit` | - | Ação ao clicar no card. |

### 4. Exemplo de uso

```kotlin
BannerCarousel(
    title = "Destaques",
    pageCount = 3
) { index ->
    BannerCard(
        title = "Título $index",
        subtitle = "Subtítulo",
        imageUrl = "https://link-da-imagem.com/$index.jpg",
        onClick = { /* ação */ }
    )
}
```
