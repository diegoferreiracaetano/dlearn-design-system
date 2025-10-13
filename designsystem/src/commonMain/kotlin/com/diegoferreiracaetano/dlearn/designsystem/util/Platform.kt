package com.diegoferreiracaetano.dlearn.designsystem.util

enum class PlatformType {
    Android,
    IOS,
    Other
}

interface Platform {
    val name: String
}

expect val currentPlatform: PlatformType

val isIOS = currentPlatform == PlatformType.IOS