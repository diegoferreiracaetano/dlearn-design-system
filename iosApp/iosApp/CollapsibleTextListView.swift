import UIKit
import SwiftUI
import DesignSystem

struct CollapsibleTextListView: UIViewControllerRepresentable {
    var chips: [AppChip]
    var onFilterChanged: (String?) -> Void
    var items: [String]

    func makeUIViewController(context: Context) -> UIViewController {
        return CollapsibleTextListUIViewController.shared.invoke(
            chips: self.chips,
            onFilterChanged: self.onFilterChanged,
            items: self.items
        )
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
