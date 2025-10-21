import UIKit
import SwiftUI
import DesignSystem

struct AppButtonView: UIViewControllerRepresentable {

    let text: String
    let type: ButtonType
    let enabled: Bool
    let onClick: () -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        AppButtonUIViewController.shared.invoke(
            text: text,
            onClick: onClick,
            type: type,
            enabled: enabled
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}



struct AppButtonContentView: View {
    var body: some View {
        AppButtonView(
            text: "Entrar com Google",
            type: .primary,
            enabled: true,
            onClick: {
                print("Botão clicado!")
            }
        )   .ignoresSafeArea()
    }
}




#Preview {
    AppButtonView(
        text: "Entrar com Google",
        type: .tertiary,
        enabled: true,
        onClick: {
            print("Botão clicado!")
        }
    )
    .ignoresSafeArea()
}
