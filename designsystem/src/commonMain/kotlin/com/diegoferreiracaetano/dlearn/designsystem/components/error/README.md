# Error Handling System

O sistema de erro do DLearn Design System é composto por uma UI flexível (`AppError`) e uma fábrica inteligente (`AppErrorFactory`) que mapeia exceções e estado de rede para modelos de erro amigáveis (`AppErrorData`).

## Componentes

### `AppError`
Um componente versátil que exibe o estado de erro com suporte a ações primárias e secundárias empilhadas verticalmente. Ele pode ser usado como apenas o conteúdo ou em tela cheia.

#### Apenas Conteúdo (Padrão)
Ideal para uso dentro de outros containers como `AppContainer`.

```kotlin
AppError(
    errorData = GenericError(), // Obrigatório: define o título, descrição e imagem
    onPrimary = { /* lógica de tentativa */ },
    primaryText = Res.string.action_retry, // Opcional: padrão é extraído do recurso
    onSecondary = { /* ação secundária */ },
    secondaryText = Res.string.action_close // Opcional: padrão é "Fechar"
)
```

#### Tela Cheia (`fullScreen = true`)
Encapsula o layout de erro dentro de um `Scaffold` com uma `AppTopBar`.

```kotlin
AppError(
    fullScreen = true,
    errorData = errorData,
    onPrimary = { /* lógica de tentativa */ },
    onClose = { /* fechar a tela no topo */ }
)
```

### `AppErrorFactory`
Responsável por criar a instância correta de `AppErrorData` baseada no contexto de exceção e conectividade.

```kotlin
val errorData = AppErrorFactory(
    throwable = exception,
    isNetworkAvailable = true
)
```

## Localização
Todos os textos padrão são fornecidos em Português (PT-BR) dentro das implementações de `AppErrorData`.
- `NoInternetError`: "Sem Conexão com a Internet"
- `NotFoundError`: "Recurso não Encontrado"
- `AuthError`: "Erro de Autenticação"
- `ServerError`: "Erro no Servidor"
- `TimeoutError`: "Tempo Esgotado"
- `GenericError`: "Erro Inesperado"
