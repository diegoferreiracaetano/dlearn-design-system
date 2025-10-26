// swift-tools-version:5.8
import PackageDescription

// ✅ PASSO 1: Adicione este bloco.
// O KMMBridge irá substituir a linha 'let binaryPath' automaticamente.
// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let binaryPath = "WILL_BE_REPLACED_BY_KMMBRIDGE"
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
        // ✅ PASSO 2: Use a variável do bloco KMMBridge aqui
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