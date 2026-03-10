# Error Handling System

O sistema de erro do DLearn Design System é composto por uma UI flexível (`AppError`) e uma fábrica inteligente (`AppErrorFactory`) que mapeia exceções e estado de rede para modelos de erro amigáveis (`AppErrorData`).

## Componentes

### `AppError`
Um componente de tela cheia que exibe o estado de erro com suporte a ações primárias e secundárias empilhadas verticalmente.

```kotlin
AppError(
    throwable = exception, // Opcional: determina o tipo de erro via factory
    onPrimary = { /* lógica de tentativa */ },
    primaryText = "Tentar Novamente", // Opcional: padrão é extraído do recurso
    onSecondary = { /* ação secundária */ },
    secondaryText = "Voltar", // Opcional: padrão é "Fechar"
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
