@file:Suppress("PackageDirectoryMismatch")
package com.diegoferreiracaetano.dlearn.designsystem.generated.resources

import org.jetbrains.compose.resources.DrawableResource

/**
 * Workaround to expose generated resources to other modules.
 * In Compose Multiplatform, generated 'Res' object and its members are 'internal' by default.
 */
object DesignSystemRes {
    val google: DrawableResource get() = Res.drawable.google
    val dlearn_logo: DrawableResource get() = Res.drawable.dlearn_logo
    val profile: DrawableResource get() = Res.drawable.profile
}
