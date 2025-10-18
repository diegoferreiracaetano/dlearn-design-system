import UIKit
import SwiftUI
import DesignSystem

struct ScreenLoadingView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return ScreenLoadingUIViewController.shared.invoke()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
