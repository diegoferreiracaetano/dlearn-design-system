# DLearn Design System

[![Latest Release](https://img.shields.io/github/v/release/diegoferreiracaetano/dlearn-design-system)](https://github.com/diegoferreiracaetano/dlearn-design-system/releases)
[![Documentation](https://img.shields.io/badge/docs-dokka-brightgreen)](https://diegoferreiracaetano.github.io/dlearn-design-system/)

Este é um projeto **Kotlin Multiplatform (KMP)** focado em Design System, atendendo Android, iOS e Web utilizando Compose Multiplatform.

## 📚 Documentação API
A documentação técnica detalhada de todas as classes e funções, gerada via **Dokka**, pode ser acessada em:
👉 [**DLearn Design System - Dokka Docs**](https://diegoferreiracaetano.github.io/dlearn-design-system/)

## 🚀 Componentes do Design System

Abaixo você encontra a visão geral dos componentes disponíveis. Clique no nome de cada componente para ir **diretamente para sua documentação e tabela de propriedades**.

### 🔘 Interação (Buttons & Selection)
- [**AppButton**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/button/README.md#appbutton): Botões com estilos Primary, Secondary e Tertiary.
- [**AppSwitcher**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/button/README.md#appswitcher): Chave de alternância (Toggle/Switch).
- [**AppSelection**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/button/README.md#appselection): Menus de seleção e dropdowns customizados.

### 🏷️ Chips & Filters
- [**AppChipGroup**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/chip/README.md#appchipgroup): Grupo de filtros horizontais roláveis.

### 🎠 Carrosséis & Banners
- [**BannerCarousel**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/carousel/README.md#bannercarousel): Carrossel padrão com indicadores.
- [**Carousel**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/carousel/README.md#carousel): Carrossel com numeração de ranking.
- [**ContinueWatchingCarousel**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/carousel/README.md#continuewatchingcarousel): Otimizado para progresso de mídia.
- [**FullScreenBanner**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/carousel/README.md#fullscreenbanner): Banners de destaque.

### ✍️ Entrada de Dados (Forms)
- [**AppTextField**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/textfield/README.md#apptextfield): Input de texto versátil.
- [**AppOtpVerification**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/textfield/README.md#appotpverification): Campo para códigos de verificação (OTP).

### 🗺️ Navegação & Estrutura
- [**AppContainer**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/navigation/README.md#appcontainer): Scaffold base da aplicação.
- [**AppBottomNavigationBar**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/navigation/README.md#appbottomnavigationbar): Barra inferior adaptativa.
- [**AppTopBar**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/navigation/README.md#apptopbar): Barra superior padrão.
- [**AppDrawer**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/navigation/README.md#appdrawer): Menu lateral.

### 🖼️ Mídia & Imagens
- [**AppImage**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/image/README.md#appimage): Carregamento de imagens.
- [**CircularImage**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/image/README.md#circularimage): Avatares circulares.

### 🔄 Feedback Visual & Listas
- [**AppLoading**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/loading/README.md#apploading): Spinner padrão.
- [**ScreenLoading**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/loading/README.md#screenloading): Carregamento em tela cheia.
- [**AppSnackbarHost**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/alert/README.md#appsnackbarhost): Sistema de notificações.
- [**AppList**](designsystem/src/commonMain/kotlin/com/diegoferreiracaetano/dlearn/designsystem/components/list/README.md#applist): Listas com cabeçalhos colapsáveis.

---

## 🏗️ Estrutura do Projeto

* [/designsystem](designsystem/src) - Código compartilhado do Design System.
  - [commonMain](designsystem/src/commonMain/kotlin) - UI e lógica compartilhada.
  - [iosMain](designsystem/src/iosMain/kotlin) - Implementações nativas iOS.
  - [androidMain](designsystem/src/androidMain/kotlin) - Implementações nativas Android.

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
Abra o diretório [/iosApp](./iosApp) no Xcode ou utilize a configuração de execução do Android Studio.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) and [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/).
