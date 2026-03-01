### 1. Nome
`AppBottomNavigationBar`

### 2. Descrição
Componente de barra de navegação inferior que adapta sua altura e insets automaticamente entre Android e iOS. Suporta ícones selecionados/não selecionados e realce de texto para a aba ativa.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |
| `items` | `List<AppNavigationTab>` | - | Lista de abas a serem exibidas na barra. |
| `selectedRoute` | `String` | - | Rota da aba que deve estar selecionada. |
| `onTabSelected` | `(String) -> Unit` | - | Callback acionado ao selecionar uma nova aba. |

#### Data Class `AppNavigationTab`
| Prop | Tipo | Descrição |
| :--- | :--- | :--- |
| `route` | `String` | Identificador único da rota. |
| `label` | `String` | Texto exibido abaixo do ícone. |
| `selectedIcon` | `ImageVector` | Ícone exibido quando a aba está selecionada. |
| `unselectedIcon` | `ImageVector` | Ícone exibido quando a aba não está selecionada. |

### 4. Exemplo de uso

```kotlin
val tabs = listOf(
    AppNavigationTab("home", "Home", Icons.Filled.Home, Icons.Outlined.Home),
    AppNavigationTab("search", "Busca", Icons.Filled.Search, Icons.Outlined.Search)
)

AppBottomNavigationBar(
    items = tabs,
    selectedRoute = "home",
    onTabSelected = { route ->
        // Navegar para a rota
    }
)
```
