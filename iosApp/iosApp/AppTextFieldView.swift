import UIKit
import SwiftUI
import DesignSystem

// Private container UIViewController to allow replacing the Compose view on updates.
private class AppTextFieldHostingController: UIViewController {
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

// The SwiftUI bridge view for AppTextField.
struct AppTextFieldView: UIViewControllerRepresentable {
    @Binding var text: String
    var placeholder: String
    var label: String?
    var supportingText: String?
    var isError: Bool
    var type: TextFieldType

    init(
        text: Binding<String>,
        placeholder: String,
        label: String? = nil,
        supportingText: String? = nil,
        isError: Bool = false,
        type: TextFieldType = .none
    ) {
        self._text = text
        self.placeholder = placeholder
        self.label = label
        self.supportingText = supportingText
        self.isError = isError
        self.type = type
    }

    private func makeComposeViewController() -> UIViewController {
        let onValueChange: (String) -> Void = { newValue in
            DispatchQueue.main.async {
                self.text = newValue
            }
        }
        
        return AppTextFieldUIViewController.shared.invoke(
            value: self.text,
            onValueChange: onValueChange,
            placeholder: self.placeholder,
            label: self.label,
            supportingText: self.supportingText,
            isError: self.isError,
            type: self.type
        )
    }
    
    func makeUIViewController(context: Context) -> AppTextFieldHostingController {
        let container = AppTextFieldHostingController()
        container.host(makeComposeViewController())
        return container
    }

    func updateUIViewController(_ uiViewController: AppTextFieldHostingController, context: Context) {
        uiViewController.host(makeComposeViewController())
    }
}
