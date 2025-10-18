import UIKit
import SwiftUI
import DesignSystem

struct CircularImageView: UIViewControllerRepresentable {
    var resource: DrawableResource
    var contentDescription: String?

    func makeUIViewController(context: Context) -> UIViewController {
        return CircularImageUIViewController.shared.invoke(
            resource: self.resource,
            contentDescription: self.contentDescription
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
