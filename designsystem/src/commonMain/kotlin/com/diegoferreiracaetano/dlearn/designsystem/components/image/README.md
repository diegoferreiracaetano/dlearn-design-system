### 1. Nome
`AppImage`, `CircularImage`

### 2. Descrição
Componentes para exibição de imagens.

### 3. Tabela de Props (Parâmetros)

<a name="appimage"></a>
#### `AppImage`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `imageURL` | `String?` | `null` | URL da imagem remota. |

<a name="circularimage"></a>
#### `CircularImage`
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `resource` | `DrawableResource` | - | Recurso de imagem local. |

### 4. Exemplo de uso
```kotlin
CircularImage(resource = Res.drawable.user_avatar)
```
