import UIKit
import SwiftUI
import DesignSystem

struct AppChipGroupView: UIViewControllerRepresentable {
    var items: [AppChip]
    var onFilterChanged: (String?) -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        return AppChipGroupUIViewController.shared.invoke(
            items: self.items,
            onFilterChanged: self.onFilterChanged
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
