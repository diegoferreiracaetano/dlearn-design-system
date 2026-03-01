### 1. Nome
`AppSnackbarHost`

### 2. Descrição
Componente que gerencia a exibição de Snackbars customizados para o DLearn Design System, suportando tipos como Erro, Sucesso e Aviso com cores específicas.

### 3. Tabela de Props (Parâmetros)
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `hostState` | `SnackbarHostState` | - | Estado que controla a exibição do snackbar. |
| `modifier` | `Modifier` | `Modifier` | Modificador de layout do Compose. |

#### Extensão `SnackbarHostState.showAppSnackBar`
| Parâmetro | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `scope` | `CoroutineScope` | - | Escopo para lançar a animação. |
| `message` | `String` | - | Mensagem a ser exibida. |
| `type` | `SnackbarType` | `SnackbarType.ERROR` | Tipo do snackbar (ERROR, SUCCESS, WARNING). |

### 4. Exemplo de uso

```kotlin
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

AppSnackbarHost(hostState = snackbarHostState)

// Para disparar:
snackbarHostState.showAppSnackBar(
    scope = scope,
    message = "Operação realizada com sucesso!",
    type = SnackbarType.SUCCESS
)
```
