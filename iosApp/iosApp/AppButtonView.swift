import UIKit
import SwiftUI
import DesignSystem

struct AppButtonView: UIViewControllerRepresentable {
    var text: String
    var onClick: () -> Void
    var type: ButtonType
    var enabled: Bool

    init(
        text: String,
        onClick: @escaping () -> Void,
        type: ButtonType = .primary,
        enabled: Bool = true
    ) {
        self.text = text
        self.onClick = onClick
        self.type = type
        self.enabled = enabled
    }

    func makeUIViewController(context: Context) -> UIViewController {
        return AppButtonUIViewController.shared.invoke(
            text: self.text,
            onClick: self.onClick,
            type: self.type,
            image: nil,
            enabled: self.enabled
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
