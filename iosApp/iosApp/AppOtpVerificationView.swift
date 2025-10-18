import UIKit
import SwiftUI
import DesignSystem

// Private container UIViewController for stateful updates.
private class AppOtpHostingController: UIViewController {
    private var hostedVC: UIViewController?

    func host(_ vc: UIViewController) {
        if let hostedVC = self.hostedVC {
            hostedVC.willMove(toParent: nil)
            hostedVC.view.removeFromSuperview()
            hostedVC.removeFromParent()
        }
        self.hostedVC = vc
        self.addChild(vc)
        self.view.addSubview(vc.view)
        vc.view.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            vc.view.topAnchor.constraint(equalTo: self.view.topAnchor),
            vc.view.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            vc.view.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
            vc.view.bottomAnchor.constraint(equalTo: self.view.bottomAnchor)
        ])
        vc.didMove(toParent: self)
    }
}

// The SwiftUI bridge view for AppOtpVerification.
struct AppOtpVerificationView: UIViewControllerRepresentable {
    @Binding var text: String
    var isError: Bool
    var onIsComplete: (Bool) -> Void
    var onResendClick: () -> Void

    private func makeComposeViewController() -> UIViewController {
        let onOtpChange: (String, Bool) -> Void = { newText, isComplete in
            DispatchQueue.main.async {
                self.text = newText
                self.onIsComplete(isComplete)
            }
        }

        return AppOtpVerificationUIViewController.shared.invoke(
            otpText: self.text,
            isError: self.isError,
            errorText: self.isError ? "Invalid code" : nil,
            onOtpTextChange: onOtpChange,
            onResendClick: self.onResendClick
        )
    }

    func makeUIViewController(context: Context) -> AppOtpHostingController {
        let container = AppOtpHostingController()
        container.host(makeComposeViewController())
        return container
    }

    func updateUIViewController(_ uiViewController: AppOtpHostingController, context: Context) {
        uiViewController.host(makeComposeViewController())
    }
}
