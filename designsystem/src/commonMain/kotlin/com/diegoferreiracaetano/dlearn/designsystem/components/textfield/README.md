# Componentes de Entrada de Dados

### AppTextField
Campo de texto versátil para capturar informações do usuário, com suporte a placeholders, máscaras e estados de erro.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `value` | `String` | - | O texto atual do campo. |
| `onValueChange` | `(String) -> Unit` | - | Callback de mudança. |

**Exemplo de Uso**
```kotlin
AppTextField(
    value = text,
    onValueChange = { text = it },
    placeholder = "Digite seu nome"
)
```

---

### AppOtpVerification
Campo especializado para entrada de códigos de verificação de uso único (OTP), com layout de dígitos separados.

**Tabela de Props**
| Prop | Tipo | Padrão | Descrição |
| :--- | :--- | :--- | :--- |
| `otpText` | `String` | - | Texto do código. |
| `otpCount` | `Int` | `6` | Número de dígitos. |

**Exemplo de Uso**
```kotlin
AppOtpVerification(
    otpText = code,
    onOtpTextChange = { value, isComplete -> 
        if(isComplete) verify(value)
    }
)
```
