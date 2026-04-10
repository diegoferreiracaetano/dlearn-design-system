// swift-tools-version:5.8
import PackageDescription


let packageNameUI = "DesignSystemUI"
let swiftSourcePath = "designsystem/src/iosMain/swift"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/393589730.zip"
let remoteKotlinChecksum = "0bd31c915151205ad4b431ada143d1d06fa67d1086944257e73d484c1e544f6b"
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