# Estrutura e Navegação

### AppContainer
Scaffold base que organiza automaticamente a TopBar, BottomBar e o conteúdo da tela com os paddings corretos.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `topBar` | `@Composable () -> Unit` | `null` | Slot para a barra superior. |
| `bottomBar` | `@Composable () -> Unit` | `null` | Slot para a barra inferior. |

**Exemplo de Uso**
```kotlin
AppContainer(
    topBar = { AppTopBar(title = "Home") },
    bottomBar = { AppBottomNavigationBar(...) }
) { padding ->
    // Conteúdo aqui
}
```

---

### AppBottomNavigationBar
Barra de navegação inferior que se adapta visualmente para Android e iOS.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `items` | `List<AppNavigationTab>` | - | Lista de ícones e destinos. |

**Exemplo de Uso**
```kotlin
AppBottomNavigationBar(items = tabs, selectedRoute = currentRoute)
```

---

### AppTopBar
Barra superior padrão com suporte a título e ações.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `title` | `String` | - | Título central da barra. |

**Exemplo de Uso**
```kotlin
AppTopBar(title = "Configurações")
```
