// swift-tools-version:5.8
import PackageDescription

let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"


let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v14)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName, packageNameUI]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            path: "./designsystem/build/XCFrameworks/debug/\(packageName).xcframework"
        )
        .target(
            name: packageNameUI,
            dependencies: [],
            path: "designsystem/src/iosMain/swift"
        )
    ]
)