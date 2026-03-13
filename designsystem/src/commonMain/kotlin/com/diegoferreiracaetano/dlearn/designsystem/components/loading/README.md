# AppLoading

Componente de carregamento que exibe um indicador de progresso circular centralizado. Ocupa todo o espaço disponível por padrão.

### Props

| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | O modificador a ser aplicado ao contêiner. |

### Exemplo de Uso

```kotlin
AppLoading()
```

---

# ScreenLoading

Componente de carregamento em tela cheia que exibe o `AppLoading` centralizado com uma cor de fundo do tema (`surfaceVariant`).

### Props

| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `modifier` | `Modifier` | `Modifier` | O modificador a ser aplicado à tela de carregamento. |

### Exemplo de Uso

```kotlin
if (isLoading) {
    ScreenLoading()
}
```
