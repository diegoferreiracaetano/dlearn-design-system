# Feedback Component

O sistema de feedback é composto pelo componente `AppFeedback`, um componente base genérico projetado para exibir estados de feedback ao usuário, como erros, telas vazias (empty states) ou mensagens de sucesso.

## Componentes

### `AppFeedback`
O componente principal que pode ser usado de duas formas: apenas o conteúdo ou em tela cheia (com Scaffold e TopBar).

#### Apenas Conteúdo (Padrão)
Ideal para ser acoplada dentro de outros containers de tela cheia que já possuem suas próprias barras de navegação (ex: `AppContainer`).

```kotlin
AppFeedback(
    title = "Título do Feedback",
    description = "Descrição detalhada do que aconteceu ou o que fazer.",
    imageSource = AppImageSource.Resource(Res.drawable.my_illustration),
    primaryText = "Ação Principal",
    onPrimary = { /* ... */ },
    secondaryText = "Ação Secundária",
    onSecondary = { /* ... */ }
)
```

#### Tela Cheia (`fullScreen = true`)
Encapsula o layout de feedback dentro de um `Scaffold` e uma `AppTopBar` com botão de fechar.

```kotlin
AppFeedback(
    fullScreen = true,
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
- `AppError`: Para estados de erro técnicos ou de rede.
- `AppEmptyState`: Para quando uma lista ou busca não retorna resultados.

## Características
- **Layout Centralizado**: Imagem, título e descrição são centralizados na tela.
- **Ações Empilhadas**: Suporta até duas ações (primária e secundária) exibidas verticalmente no rodapé.
- **Modo FullScreen**: Suporta um modo com `Scaffold` e `TopBar` integrado.
- **Responsivo**: Adapta-se a diferentes tamanhos de tela e orientações.
