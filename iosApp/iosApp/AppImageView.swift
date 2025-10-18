import UIKit
import SwiftUI
import DesignSystem

struct AppImageView: UIViewControllerRepresentable {
    var imageURL: String?
    var imageResource: DrawableResource?
    var contentDescription: String?

    init(
        imageURL: String? = nil,
        imageResource: DrawableResource? = nil,
        contentDescription: String? = nil
    ) {
        self.imageURL = imageURL
        self.imageResource = imageResource
        self.contentDescription = contentDescription
    }

    func makeUIViewController(context: Context) -> UIViewController {
        return AppImageUIViewController.shared.invoke(
            imageURL: self.imageURL,
            imageResource: self.imageResource,
            contentDescription: self.contentDescription
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
