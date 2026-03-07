# BannerCarousel
Carrossel horizontal padrão para exibição de BannerCards. Utilizado para destaques informativos ou promocionais.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título da seção do carrossel. |
| `pageCount` | `Int` | - | Número total de páginas. |
| `pageContent` | `Composable (Int) -> Unit` | - | Conteúdo de cada página (geralmente `BannerCard`). |

### Usage
```kotlin
BannerCarousel(
    title = "Destaques",
    pageCount = items.size
) { index ->
    BannerCard(
        title = items[index].title,
        subtitle = items[index].subtitle,
        imageSource = AppImageSource.Url(items[index].url),
        onClick = { /* navegação */ }
    )
}
```

---

# FullScreenBanner
Componente de pager para exibição de banners em tela cheia, ideal para o topo de telas de início ou detalhes.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Número total de banners. |
| `pageContent` | `Composable (Int) -> Unit` | - | Conteúdo de cada página (geralmente `FullScreenVideo`). |

### Usage
```kotlin
FullScreenBanner(
    pageCount = items.size
) { index ->
    FullScreenVideo(
        title = items[index].title,
        subtitle = items[index].subtitle,
        imageSource = AppImageSource.Url(items[index].thumbnailUrl),
        onItemClick = { /* navegação */ },
        onWatchClick = { /* assistir */ },
        onAddToListClick = { /* adicionar */ }
    )
}
```

---

# PageCarousel
Carrossel especializado para fluxos de Onboarding. Possui um cartão de informações flutuante e um botão de ação.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Número total de páginas. |
| `onFinish` | `() -> Unit` | - | Callback acionado ao clicar no botão na última página. |
| `imageContent` | `Composable (Int) -> Unit` | - | Imagem de fundo para cada página. |
| `infoContent` | `Composable (Int) -> Unit` | - | Conteúdo textual/informativo para cada página. |

### Usage
```kotlin
PageCarousel(
    pageCount = 3,
    onFinish = { /* navegação */ },
    imageContent = { index -> /* Image */ },
    infoContent = { index -> /* Text */ }
)
```

---

# ContinueWatchingCarousel
Lista horizontal (LazyRow) para exibir o progresso de conteúdos em andamento.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título da seção (ex: "Continuar Assistindo"). |
| `itemCount` | `Int` | - | Número de itens na lista. |
| `itemContent` | `Composable (Int) -> Unit` | - | Renderizador de cada item. |

### Usage
```kotlin
ContinueWatchingCarousel(
    title = "Continuar Assistindo",
    itemCount = items.size
) { index ->
    ContinueWatchingCard(
        title = items[index].title,
        imageSource = AppImageSource.Url(items[index].url),
        onClick = { /* navegação */ }
    )
}
```
