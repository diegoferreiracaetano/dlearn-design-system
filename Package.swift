// swift-tools-version:5.9
import PackageDescription

let package = Package(
    name: "DesignSystem",
    platforms: [.iOS(.v14)],
    products: [
        .library(name: "DesignSystem", targets: ["DesignSystem"])
    ],
    targets: [
        .binaryTarget(
            name: "DesignSystem",
            url: "https://github.com/diegoferreiracaetano/dlearn-design-system/releases/download/1.0.4/DesignSystem.xcframework.zip",
            checksum: "564b9f931275aaa755ed4354a7ace9201661c4a7662fd648ec1a2517cbde5a43"
        )
    ]
)
