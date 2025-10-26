// swift-tools-version:5.8
import PackageDescription

let packageName = "DesignSystem"
let packageNameUI = "DesignSystemUI"

let buildType = ProcessInfo.processInfo.environment["BUILD_TYPE"] ?? "debug"
let path = "./designsystem/build/XCFrameworks/\(buildType)/\(packageName).xcframework"

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
            path: path
        )
        .target(
            name: packageNameUI,
            dependencies: [],
            path: "designsystem/src/iosMain/swift"
        )
    ]
)