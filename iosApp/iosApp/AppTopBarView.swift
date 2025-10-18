import UIKit
import SwiftUI
import DesignSystem

struct AppTopBarView: UIViewControllerRepresentable {
    var title: String?
    var onBack: (() -> Void)?
    var onMenuClick: (() -> Void)?
    var useTransparent: Bool

    init(
        title: String? = nil,
        onBack: (() -> Void)? = nil,
        onMenuClick: (() -> Void)? = nil,
        useTransparent: Bool = false
    ) {
        self.title = title
        self.onBack = onBack
        self.onMenuClick = onMenuClick
        self.useTransparent = useTransparent
    }

    func makeUIViewController(context: Context) -> UIViewController {
        return AppTopBarUIViewController.shared.invoke(
            title: self.title,
            onBack: self.onBack,
            onFavorite: nil,
            onMenuClick: self.onMenuClick,
            useTransparent: self.useTransparent
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
