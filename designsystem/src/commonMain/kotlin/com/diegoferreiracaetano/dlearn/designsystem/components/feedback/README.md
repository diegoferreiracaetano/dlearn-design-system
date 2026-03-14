# Feedback Component

O sistema de feedback é composto por `AppFeedback` e `AppFeedbackContent`, componentes bases genéricos projetados para exibir estados de feedback ao usuário, como erros, telas vazias (empty states) ou mensagens de sucesso.

## Componentes

### `AppFeedbackContent`
A variação de conteúdo (layout sem Scaffold ou App Bar no topo). Ideal para ser acoplada dentro de outros containers de tela cheia que já possuem suas próprias barras de navegação (ex: `AppContainer`).

```kotlin
AppFeedbackContent(
    title = "Título do Feedback",
    description = "Descrição detalhada do que aconteceu ou o que fazer.",
    imageSource = AppImageSource.Resource(Res.drawable.my_illustration),
    primaryText = "Ação Principal",
    onPrimary = { /* ... */ },
    secondaryText = "Ação Secundária",
    onSecondary = { /* ... */ }
)
```

### `AppFeedback`
O componente de tela cheia, que encapsula o `AppFeedbackContent` dentro de um `Scaffold` e uma `AppTopBar` com botão de fechar.

```kotlin
AppFeedback(
    title = "Título do Feedback",
    description = "Descrição detalhada",
    imageSource = AppImageSource.Resource(Res.drawable.my_illustration),
    primaryText = "Ação Principal",
    onPrimary = { /* ... */ },
    onClose = { /* fechar tela */ }
)
```

## Uso

Este componente não deve ser usado diretamente na maioria dos casos. Em vez disso, use os componentes especializados:
- `AppError` e `AppErrorContent`: Para estados de erro técnicos ou de rede.
- `AppEmptyState`: Para quando uma lista ou busca não retorna resultados.

## Características
- **Layout Centralizado**: Imagem, título e descrição são centralizados na tela.
- **Ações Empilhadas**: Suporta até duas ações (primária e secundária) exibidas verticalmente no rodapé.
- **Toolbar Opcional**: Suporta um botão de fechar no topo.
- **Responsivo**: Adapta-se a diferentes tamanhos de tela e orientações.
