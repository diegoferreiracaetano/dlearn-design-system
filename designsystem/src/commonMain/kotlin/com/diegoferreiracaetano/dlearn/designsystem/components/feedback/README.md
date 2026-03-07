# Feedback Component

O `AppFeedback` é um componente base genérico projetado para exibir estados de feedback ao usuário, como erros, telas vazias (empty states) ou mensagens de sucesso.

## Uso

Este componente não deve ser usado diretamente na maioria dos casos. Em vez disso, use os componentes especializados:
- `AppError`: Para estados de erro técnicos ou de rede.
- `AppEmptyState`: Para quando uma lista ou busca não retorna resultados.

### Exemplo de Base

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

## Características
- **Layout Centralizado**: Imagem, título e descrição são centralizados na tela.
- **Ações Empilhadas**: Suporta até duas ações (primária e secundária) exibidas verticalmente no rodapé.
- **Toolbar Opcional**: Suporta um botão de fechar no topo.
- **Responsivo**: Adapta-se a diferentes tamanhos de tela e orientações.
