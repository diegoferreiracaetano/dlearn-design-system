// swift-tools-version:5.8
import PackageDescription


let packageNameUI = "DesignSystemUI"
let swiftSourcePath = "designsystem/src/iosMain/swift"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/356485424.zip"
let remoteKotlinChecksum = "8771498b25ae0dacbcedb6f8f2868fa81d3ea523012120d61f6beb6041144f14"
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