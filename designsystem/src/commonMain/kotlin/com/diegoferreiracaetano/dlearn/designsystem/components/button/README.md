# Componentes de Interação

### AppButton
Componente de botão padrão com suporte a diferentes estilos e estados.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `text` | `String` | - | Texto exibido no botão. |
| `onClick` | `() -> Unit` | - | Ação ao clicar. |
| `type` | `ButtonType` | `PRIMARY` | Estilo (PRIMARY, SECONDARY, TERTIARY). |

**Exemplo de Uso**
```kotlin
AppButton(
    text = "Confirmar",
    onClick = { /* ação */ },
    type = ButtonType.PRIMARY
)
```

---

### AppSwitcher
Chave de alternância (Toggle/Switch) para estados binários.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `isChecked` | `Boolean` | - | Estado atual da chave. |
| `onCheckedChange` | `(Boolean) -> Unit` | - | Callback de mudança. |

**Exemplo de Uso**
```kotlin
AppSwitcher(
    isChecked = isChecked,
    onCheckedChange = { isChecked = it }
)
```

---

### AppSelection
Menu de seleção/dropdown customizado.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `options` | `List<AppSelectionOption>` | - | Lista de opções. |
| `onOptionSelected` | `(AppSelectionOption) -> Unit` | - | Callback de seleção. |

**Exemplo de Uso**
```kotlin
AppSelectionSimple(
    list = listOf("Opção 1", "Opção 2"),
    onSelectionChanged = { option -> println(option.label) }
)
```
