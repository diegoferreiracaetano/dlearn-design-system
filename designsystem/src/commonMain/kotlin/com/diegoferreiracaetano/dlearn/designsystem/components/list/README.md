# List Components

Este pacote contém componentes fundamentais para a construção de listas, telas de configurações e seções de perfil, seguindo os padrões visuais do DLearn.

## AppList

O `AppList` é um wrapper sobre o `LazyColumn` que adiciona suporte nativo a um cabeçalho colapsável (collapsible header). O cabeçalho se esconde ao rolar para baixo e reaparece ao rolar para cima ou atingir o topo da lista.

### Propriedades

| Propriedade | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | O modificador a ser aplicado à lista. |
| `listState` | `LazyListState` | `rememberLazyListState()` | Estado da lista para controle de scroll externo. |
| `collapsibleContent` | `@Composable (() -> Unit)?` | `null` | Composable opcional para o cabeçalho colapsável. |
| `content` | `LazyListScope.() -> Unit` | - | O conteúdo da `LazyColumn` (items, stickyHeaders, etc). |

### Exemplo de Uso

```kotlin
AppList(
    collapsibleContent = {
        AppSectionTitle(title = "Destaques")
    }
) {
    items(movies) { movie ->
        AppMovieItem(movie = movie, onClick = { /* ... */ })
    }
}
```

---

## Componentes de Linha

### AppSectionTitle

Componente de texto usado como cabeçalho de seções.

**Uso:**
```kotlin
AppSectionTitle(title = "Configurações da Conta")
```

### AppSelectableRow

Uma linha projetada para listas de seleção (ex: Idiomas). Exibe um ícone de check e altera o peso da fonte quando selecionada.

**Uso:**
```kotlin
AppSelectableRow(
    label = "Português (Brasil)",
    isSelected = true,
    onClick = { /* ... */ }
)
```

### AppTextRow

Componente de linha genérico para menus, com suporte a label e um valor ou switch opcional à direita.

**Uso:**
```kotlin
AppTextRow(
    label = "Notificações",
    onClick = { /* ... */ }
)
```

---
*Mantido pelo Time de Design System*
