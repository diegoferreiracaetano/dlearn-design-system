# AppSearchBar

Barra de busca simplificada baseada no Material 3 SearchBar. Ela é projetada para estar sempre ativa/expandida, focada na funcionalidade de busca com um botão de navegação para voltar e gerenciamento interno de estado.

## Propriedades

| Propriedade | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `onSearch` | `(String) -> Unit` | - | Callback invocado quando o texto da busca é alterado ou a busca é disparada. |
| `onBackClick` | `() -> Unit` | - | Callback invocado ao clicar no botão de voltar (ícone à esquerda). |
| `modifier` | `Modifier` | `Modifier` | O modificador a ser aplicado à barra de busca. |
| `placeholder` | `String` | `Res.string.search_placeholder` | Texto de placeholder exibido quando o campo está vazio. |
| `content` | `@Composable ColumnScope.() -> Unit` | `{}` | Conteúdo exibido abaixo do campo de entrada (resultados, loading, erro). |

## Estados Suportados

O componente é flexível e permite exibir diferentes estados através do parâmetro `content`:

1.  **Sucesso**: Exiba uma lista de resultados (ex: `LazyColumn` com `AppMovieItem`).
2.  **Carregamento**: Use o componente `AppLoading`.
3.  **Vazio**: Use o componente `AppEmptyState`.
4.  **Erro**: Use o componente `AppError`.

## Exemplo de Uso

```kotlin
AppSearchBar(
    onSearch = { query -> /* Executar busca ou filtrar lista */ },
    onBackClick = { /* Navegar de volta */ },
    placeholder = "Buscar filmes..."
) {
    if (isLoading) {
        AppLoading()
    } else if (results.isEmpty()) {
        AppEmptyState(
            title = "Sem resultados",
            description = "Tente buscar por outro termo.",
            imageSource = AppImageSource.Resource(Res.drawable.search)
        )
    } else {
        LazyColumn {
            items(results) { movie ->
                AppMovieItem(movie = movie, onClick = { /* ... */ })
            }
        }
    }
}
```
