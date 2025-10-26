// swift-tools-version:5.8
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/309005210.zip"
let remoteKotlinChecksum = "5c5f9dd6bde10b1b47e4878da78947eec6cbaea96c4caa3baba6a3b6d25dbc1a"
let packageName = "DesignSystem"
// END KMMBRIDGE BLOCK

let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"
let swiftSourcePath = "designsystem/src/iosMain/swift"

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
            path: binaryPath
        ),
        .target(
            name: packageNameUI,
            dependencies: [
                .target(name: packageName)
            ],
            path: swiftSourcePath
        )
    ]
)