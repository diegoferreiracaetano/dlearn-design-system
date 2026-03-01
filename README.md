# DLearn Design System

[![Latest Release](https://img.shields.io/github/v/release/diegoferreiracaetano/dlearn-design-system)](https://github.com/diegoferreiracaetano/dlearn-design-system/releases)

Este é um projeto **Kotlin Multiplatform (KMP)** focado em Design System, atendendo Android, iOS e Web utilizando Compose Multiplatform.

## 🚀 Componentes do Design System

Abaixo você encontra a documentação detalhada de cada componente disponível no sistema:

- 🔘 [**Button**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/button/README.md) - Botões primários, secundários e terciários.
- 🏷️ [**Chip**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/chip/README.md) - Grupos de filtros e seleção.
- 📜 [**List**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/list/README.md) - Listas com cabeçalhos colapsáveis.
- ⚠️ [**Alert/Snackbar**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/alert/README.md) - Mensagens de erro, sucesso e aviso.
- 🖼️ [**Image**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/image/README.md) - Carregamento de imagens remotas e locais.
- 🔄 [**Loading**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/loading/README.md) - Indicadores de progresso animados.
- 🎠 [**Carousel**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/carousel/README.md) - Carrossel de banners e destaques.
- ✍️ [**TextField**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/textfield/README.md) - Campos de entrada de texto e senha.
- 🗺️ [**Navigation**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/navigation/README.md) - Barra de navegação inferior adaptativa.

---

## 🏗️ Estrutura do Projeto

* [/designsystem](designsystem/src) - Código compartilhado do Design System.
  - [commonMain](designsystem/src/commonMain/kotlin) - UI e lógica compartilhada entre todas as plataformas.
  - [iosMain](designsystem/src/iosMain/kotlin) - Implementações específicas para iOS.
  - [androidMain](designsystem/src/androidMain/kotlin) - Implementações específicas para Android.

* [/iosApp](./iosApp/iosApp) - Ponto de entrada da aplicação iOS em SwiftUI.

## 🛠️ Como rodar

### Android
```shell
./gradlew :designsystem:assembleDebug
```

### Web (Wasm target)
```shell
./gradlew :designsystem:wasmJsBrowserDevelopmentRun
```

### iOS
Abra o diretório [/iosApp](./iosApp) no Xcode ou use a configuração de rodar do Android Studio.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) and [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/).
