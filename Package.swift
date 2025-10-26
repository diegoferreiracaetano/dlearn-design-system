// swift-tools-version:5.8
import PackageDescription

let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/308932346.zip"
let remoteKotlinChecksum = "d65dc2277dbff6936533c3300e15435d51a25b605cc55c7d02d03a9c3bdb4045"
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
            path: "./designsystem/build/XCFrameworks/release/\(packageName).xcframework"
        )
        .target(
            name: packageNameUI,
            dependencies: [],
            path: "designsystem/src/iosMain/swift"
        )
    ]
)