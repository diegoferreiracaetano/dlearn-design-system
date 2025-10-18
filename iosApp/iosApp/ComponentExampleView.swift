import SwiftUI
import DesignSystem

private struct UIViewControllerHolder: UIViewControllerRepresentable {
    let controller: UIViewController
    func makeUIViewController(context: Context) -> UIViewController { return controller }
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ComponentExampleView: View {
    @StateObject private var snackbarManager = AppSnackbarManager()
    
    // State for Components
    @State private var selectedFilter: String? = nil
    @State private var isLoading = false
    @State private var emailText = ""
    @State private var passwordText = ""
    @State private var otpText = ""
    @State private var isOtpError = false

    // Sample Data (placeholders for brevity)
    let sampleChipItems: [AppChip] = [/*...data...*/]
    let sampleCarouselItems: [CarouselItem] = [/*...data...*/]
    let sampleBannerItems: [BannerCardItem] = [/*...data...*/]
    let sampleListItems = (1...30).map { "List Item \($0)" }

    var body: some View {
        ZStack {
            VStack(spacing: 0) {
                AppTopBarView(title: "SwiftUI + KMM", onMenuClick: { print("Menu clicked!") }).frame(height: 56)
                AppChipGroupView(items: sampleChipItems) { newFilter in self.selectedFilter = newFilter }.frame(height: 50)

                ScrollView {
                    VStack(spacing: 24) {
                        Text("TextField & OTP Examples").font(.headline)
                        AppTextFieldView(text: $emailText, placeholder: "Email", isError: !emailText.contains("@") && !emailText.isEmpty, supportingText: "Please enter a valid email.").frame(height: 80)
                        AppTextFieldView(text: $passwordText, placeholder: "Password", isError: passwordText.count < 6 && !passwordText.isEmpty, type: .password, supportingText: "Must be at least 6 characters.").frame(height: 80)
                        AppOtpVerificationView(text: $otpText, isError: isOtpError, onIsComplete: { isComplete in
                            if isComplete { self.isOtpError = (self.otpText != "123456") }
                        }, onResendClick: { self.otpText = "" }).frame(height: 120)
                        
                        AppButtonView(text: "Toggle Screen Loading", onClick: { isLoading.toggle() }).frame(height: 56)
                        CarouselView(title: "New Releases", items: sampleCarouselItems).frame(height: 280)
                        BannerCardCarouselView(title: "Favoritos", items: sampleBannerItems).aspectRatio(16/9, contentMode: .fit)
                        AppButtonView(text: "Show Success Snackbar", onClick: { snackbarManager.show(message: "Success!", type: .success) }).frame(height: 56)
                        Text("Image & Loading Examples").font(.headline)
                        HStack(spacing: 16) {
                            AppImageView(imageURL: "https://www.jetbrains.com/company/brand/img/jetbrains_logo.svg").frame(width: 80, height: 80)
                            CircularImageView(resource: Res.drawable.dlearn_logo).frame(width: 80, height: 80)
                            AppLoadingView().frame(width: 80, height: 80)
                        }
                    }
                    .padding()
                }
            }
            .ignoresSafeArea(edges: .bottom)

            UIViewControllerHolder(controller: snackbarManager.snackbarHostController).frame(width: 0, height: 0)
            if isLoading {
                ScreenLoadingView().ignoresSafeArea().onTapGesture { isLoading = false }
            }
        }
    }
}
