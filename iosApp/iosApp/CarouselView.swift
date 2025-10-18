import UIKit
import SwiftUI
import DesignSystem

struct CarouselView: UIViewControllerRepresentable {
    var title: String
    var items: [CarouselItem]

    func makeUIViewController(context: Context) -> UIViewController {
        // Swift arrays are automatically bridged to Kotlin Lists.
        return CarouselUIViewController.shared.invoke(
            title: self.title,
            items: self.items
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
