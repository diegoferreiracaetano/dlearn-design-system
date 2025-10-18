import UIKit
import SwiftUI
import DesignSystem

struct BannerCardCarouselView: UIViewControllerRepresentable {
    var title: String
    var items: [BannerCardItem]

    func makeUIViewController(context: Context) -> UIViewController {
        return BannerCardCarouselUIViewController.shared.invoke(
            title: self.title,
            items: self.items
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
