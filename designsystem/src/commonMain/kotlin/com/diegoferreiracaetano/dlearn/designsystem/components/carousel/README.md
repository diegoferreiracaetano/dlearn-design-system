# Carrosséis e Banners

Esta seção contém componentes de carrossel e banners reutilizáveis, construídos sobre uma base unificada (`AppCarousel`) para garantir consistência visual e comportamento de navegação.

### AppCarousel (Base)
O componente interno que gerencia a lógica de `HorizontalPager` e `PageIndicator`. Não deve ser usado diretamente fora do pacote de carrosséis.

---

### BannerCarousel
Carrossel horizontal padrão para exibição de `BannerCard`s. Utilizado para destaques informativos ou promocionais que não ocupam a tela inteira.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título da seção do carrossel. |
| `pageCount` | `Int` | - | Número total de páginas. |
| `pageContent` | `Composable (Int) -> Unit` | - | Conteúdo de cada página (geralmente `BannerCard`). |

**Exemplo de Uso**
```kotlin
BannerCarousel(
    title = "Destaques",
    pageCount = items.size
) { index ->
    BannerCard(
        title = items[index].title,
        subtitle = items[index].subtitle,
        imageUrl = items[index].url,
        onClick = { /* navegação */ }
    )
}
```

---

### FullScreenBanner
Componente de pager para exibição de banners em tela cheia (`FullScreenVideo`), ideal para o topo de telas de início ou detalhes.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Número total de banners. |
| `pageContent` | `Composable (Int) -> Unit` | - | Conteúdo de cada página (geralmente `FullScreenVideo`). |

---

### PageCarousel
Carrossel especializado para fluxos de Onboarding. Possui um cartão de informações flutuante com sombra e um botão de ação principal.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `pageCount` | `Int` | - | Número total de páginas. |
| `onFinish` | `() -> Unit` | - | Callback acionado ao clicar no botão na última página. |
| `imageContent` | `Composable (Int) -> Unit` | - | Imagem de fundo para cada página. |
| `infoContent` | `Composable (Int) -> Unit` | - | Conteúdo textual/informativo para cada página. |

---

### ContinueWatchingCarousel
Lista horizontal (`LazyRow`) para exibir o progresso de conteúdos em andamento através de `ContinueWatchingCard`s.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título da seção (ex: "Continuar Assistindo"). |
| `itemCount` | `Int` | - | Número de itens na lista. |
| `itemContent` | `Composable (Int) -> Unit` | - | Renderizador de cada item (geralmente `ContinueWatchingCard`). |
