import UIKit
import SwiftUI
import DesignSystem

struct AppLoadingView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return AppLoadingUIViewController.shared.invoke()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
