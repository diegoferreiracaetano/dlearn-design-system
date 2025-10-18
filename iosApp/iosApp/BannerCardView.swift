import UIKit
import SwiftUI
import DesignSystem

struct BannerCardView: UIViewControllerRepresentable {
    var title: String
    var subtitle: String
    var imageResource: DrawableResource?
    var imageUrl: String?
    var onClick: () -> Void

    init(
        title: String,
        subtitle: String,
        imageResource: DrawableResource? = nil,
        imageUrl: String? = nil,
        onClick: @escaping () -> Void
    ) {
        self.title = title
        self.subtitle = subtitle
        self.imageResource = imageResource
        self.imageUrl = imageUrl
        self.onClick = onClick
    }

    func makeUIViewController(context: Context) -> UIViewController {
        return BannerCardUIViewController.shared.invoke(
            title: self.title,
            subtitle: self.subtitle,
            imageResource: self.imageResource,
            imageUrl: self.imageUrl,
            onClick: self.onClick
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
