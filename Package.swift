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
            url: "https://github.com/diegoferreiracaetano/dlearn-design-system/releases/download/1.0.6/DesignSystem.xcframework.zip",
            checksum: "f2b1285edf91831a70fa2957dda31599046a3fc683111ba1c0881306dd83df4f"
        )
    ]
)
