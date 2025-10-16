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
            url: "https://github.com/diegoferreiracaetano/dlearn-design-system/releases/download/1.0.1/DesignSystem.xcframework.zip",
            checksum: "027a47ec35be32f2d0155f1c790e4154418ce79cdb04a18639e6b9908ffddaf3"
        )
    ]
)
