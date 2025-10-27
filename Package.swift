// swift-tools-version:5.8
import PackageDescription


let packageNameUI = "DesignSystemUI"
let swiftSourcePath = "designsystem/src/iosMain/swift"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/309048022.zip"
let remoteKotlinChecksum = "dcc7d9a8edc582e63741f9ee212f002b5d56427b57b2f08e35f82d396bda7907"
let packageName = "DesignSystem"
// END KMMBRIDGE BLOCK

let binaryPath = "./designsystem/build/XCFrameworks/release/\(packageName).xcframework"

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