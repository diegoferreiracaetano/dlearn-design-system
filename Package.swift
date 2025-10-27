// swift-tools-version:5.8
import PackageDescription


let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"
let swiftSourcePath = "designsystem/src/iosMain/swift"

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://api.github.com/repos/diegoferreiracaetano/dlearn-design-system/releases/assets/309038250.zip"
let remoteKotlinChecksum = "bf85848140613e11ee71d774f62256da681a4ba1b593a4d919b880afed370ab9"
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