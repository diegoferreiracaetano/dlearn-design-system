// swift-tools-version:5.8
import PackageDescription

let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/308706194.zip"
let remoteKotlinChecksum = "e39a1a370842514467ba0b0873d541e7f54d848e5d626a008f434d5f1fa0c069"
let packageName = "DesignSystem"
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
            path: "./designsystem/build/XCFrameworks/debug/\(packageName).xcframework"
        )
        .target(
            name: packageNameUI,
            dependencies: [],
            path: "designsystem/src/iosMain/swift"
        )
    ]
)