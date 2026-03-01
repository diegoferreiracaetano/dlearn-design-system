# Carrosséis e Banners

### BannerCarousel
Carrossel horizontal padrão para exibição de banners informativos ou promocionais.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `items` | `List<BannerItem>` | - | Lista de itens contendo imagem e link. |

**Exemplo de Uso**
```kotlin
BannerCarousel(
    items = listOf(BannerItem(image = "url", link = "home"))
)
```

---

### Carousel
Carrossel versátil com suporte a títulos de seção e diferentes tipos de itens (como Ranking/Top 10).

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título exibido acima do carrossel. |
| `items` | `List<CarouselItem>` | - | Itens com imagem, título e metadados. |

**Exemplo de Uso**
```kotlin
Carousel(
    title = "Top 10 no Brasil hoje",
    items = myCarouselItems
)
```

---

### ContinueWatchingCarousel
Componente especializado para exibir o progresso de conteúdos que o usuário começou a assistir.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `items` | `List<ContinueWatchingItem>` | - | Itens com título e percentual de progresso. |

**Exemplo de Uso**
```kotlin
ContinueWatchingCarousel(
    items = listOf(ContinueWatchingItem(title = "Episódio 1", progress = 0.5f))
)
```

---

### FullScreenBanner
Banner de tela cheia para destaques principais com botões de ação direta.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título principal do banner. |
| `onWatchClick` | `() -> Unit` | - | Ação do botão "Assistir". |
| `onAddToListClick` | `() -> Unit` | - | Ação do botão "Minha Lista". |

**Exemplo de Uso**
```kotlin
FullScreenBanner(
    title = "O Senhor dos Anéis",
    onWatchClick = { /* play */ },
    onAddToListClick = { /* save */ }
)
```
