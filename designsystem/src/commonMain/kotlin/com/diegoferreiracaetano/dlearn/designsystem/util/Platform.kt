package com.diegoferreiracaetano.dlearn.designsystem.util

enum class PlatformType {
    Android,
    IOS,
    Other
}

expect val currentPlatform: PlatformType

val isIOS = currentPlatform == PlatformType.IOS
