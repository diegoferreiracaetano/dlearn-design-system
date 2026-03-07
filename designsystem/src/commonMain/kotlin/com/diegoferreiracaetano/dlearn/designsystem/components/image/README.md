# AppImage
Componente para exibição de imagens. Suporta carregamento de URLs remotas, recursos locais ou exibe um placeholder padrão através do `AppImageSource`.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `source` | `AppImageSource?` | `null` | Fonte da imagem (URL ou Recurso). |
| `contentDescription` | `String?` | `null` | Descrição de acessibilidade. |

### Usage
```kotlin
// Usando as extensões para criar AppImageSource
AppImage(source = "https://example.com/image.jpg".toAppImageSource())

// Ou de forma explícita
AppImage(source = AppImageSource.Url("https://example.com/image.jpg"))
```

---

# AppImageCircular
Componente para exibição de imagens em formato circular. Suporta carregamento de URLs remotas, recursos locais ou exibe um placeholder padrão através do `AppImageSource`.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `source` | `AppImageSource?` | `null` | Fonte da imagem (URL ou Recurso). |
| `contentDescription` | `String?` | `null` | Descrição de acessibilidade. |

### Usage
```kotlin
// Usando as extensões para criar AppImageSource
AppImageCircular(source = Res.drawable.user_avatar.toAppImageSource())

// Ou de forma explícita
AppImageCircular(source = AppImageSource.Resource(Res.drawable.user_avatar))
```
