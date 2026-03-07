# AppImage
Componente para exibição de imagens. Suporta carregamento de URLs remotas, recursos locais ou exibe um placeholder padrão através do `AppImageSource`.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `source` | `AppImageSource?` | `null` | Fonte da imagem (URL ou Recurso). |
| `contentDescription` | `String?` | `null` | Descrição de acessibilidade. |

### Usage
```kotlin
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
AppImageCircular(source = AppImageSource.Resource(Res.drawable.user_avatar))
```
