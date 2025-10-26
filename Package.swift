// swift-tools-version:5.8
import PackageDescription

let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
// END KMMBRIDGE BLOCK

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
            path: "./designsystem/build/XCFrameworks/release/\(packageName).xcframework"
        )
        .target(
            name: packageNameUI,
            dependencies: [],
            path: "designsystem/src/iosMain/swift"
        )
    ]
)