import UIKit
import SwiftUI
import DesignSystem

public struct AppButtonViewRepresentable: UIViewControllerRepresentable {

    let text: String
    let type: ButtonType
    let enabled: Bool
    let onClick: () -> Void

    public func makeUIViewController(context: Context) -> UIViewController {
        AppButtonUIViewControllerKt.createAppButtonUIViewController(
            text: text,
            onClick: onClick,
            type: type,
            enabled: enabled
        )
    }

    public func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

public struct AppButtonView: View {

    let text: String
    let type: ButtonType
    let enabled: Bool
    let onClick: () -> Void

    public init(
        text: String,
        type: ButtonType = .primary,
        enabled: Bool = true,
        onClick: @escaping () -> Void = {}
    ) {
        self.text = text
        self.type = type
        self.enabled = enabled
        self.onClick = onClick
    }

    public var body: some View {
        AppButtonViewRepresentable(
            text: text,
            type: type,
            enabled: enabled,
            onClick: onClick
        )
    }
}
