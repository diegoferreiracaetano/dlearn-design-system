// swift-tools-version:5.8
import PackageDescription


let packageNameUI = "DesignSystemUI"
let swiftSourcePath = "designsystem/src/iosMain/swift"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/328348569.zip"
let remoteKotlinChecksum = "b6aceb47b032624d3c3b1fbd75b35dc4f5aeb1aa5c725e32319959ffea8fdcb5"
let packageName = "DesignSystem"
// END KMMBRIDGE BLOCK

let binaryPath = "designsystem/build/XCFrameworks/debug/\(packageName).xcframework"

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
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
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