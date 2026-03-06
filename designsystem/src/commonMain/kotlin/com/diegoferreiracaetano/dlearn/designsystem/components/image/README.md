# AppImage
Componente para exibição de imagens. Suporta carregamento de URLs remotas, recursos locais ou exibe um placeholder padrão.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `imageURL` | `String?` | `null` | URL da imagem remota. |
| `imageResource` | `DrawableResource?` | `null` | Recurso de imagem local. |
| `contentDescription` | `String?` | `null` | Descrição de acessibilidade. |

### Usage
```kotlin
AppImage(imageURL = "https://example.com/image.jpg")
```

---

# AppImageCircular
Componente para exibição de imagens em formato circular. Suporta carregamento de URLs remotas, recursos locais ou exibe um placeholder padrão.

### Props
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `imageURL` | `String?` | `null` | URL da imagem remota. |
| `imageResource` | `DrawableResource?` | `null` | Recurso de imagem local. |
| `contentDescription` | `String?` | `null` | Descrição de acessibilidade. |

### Usage
```kotlin
AppImageCircular(imageResource = Res.drawable.user_avatar)
```
