package com.diegoferreiracaetano.dlearn.designsystem.icons

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathBuilder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object AppIcons {

    val Facebook: ImageVector
        get() = ImageVector.Builder(
            name = "Facebook",
            defaultWidth = 96.dp,
            defaultHeight = 96.dp,
            viewportWidth = 96f,
            viewportHeight = 96f
        ).apply {
            path(fill = SolidColor(Color(0xFF4267B2))) {
                drawCircle(48f, 48f, 48f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(54f, 30f)
                horizontalLineTo(62f)
                verticalLineTo(20f)
                horizontalLineTo(54f)
                curveTo(45f, 20f, 40f, 25f, 40f, 34f)
                verticalLineTo(40f)
                horizontalLineTo(32f)
                verticalLineTo(50f)
                horizontalLineTo(40f)
                verticalLineTo(76f)
                horizontalLineTo(50f)
                verticalLineTo(50f)
                horizontalLineTo(60f)
                lineTo(62f, 40f)
                horizontalLineTo(50f)
                verticalLineTo(35f)
                curveTo(50f, 32f, 51f, 30f, 54f, 30f)
                close()
            }
        }.build()

    val Instagram: ImageVector
        get() = ImageVector.Builder(
            name = "Instagram",
            defaultWidth = 96.dp,
            defaultHeight = 96.dp,
            viewportWidth = 96f,
            viewportHeight = 96f
        ).apply {
            path(
                fill = Brush.radialGradient(
                    0.0f to Color(0xFFFFD76B),
                    0.5f to Color(0xFFFF0069),
                    1.0f to Color(0xFF7A2FFF),
                    center = androidx.compose.ui.geometry.Offset(28.8f, 28.8f),
                    radius = 96f
                )
            ) {
                drawCircle(48f, 48f, 48f)
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 4f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(38f, 26f)
                horizontalLineTo(58f)
                curveTo(64.6f, 26f, 70f, 31.4f, 70f, 38f)
                verticalLineTo(58f)
                curveTo(70f, 64.6f, 64.6f, 70f, 58f, 70f)
                horizontalLineTo(38f)
                curveTo(31.4f, 70f, 26f, 64.6f, 26f, 58f)
                verticalLineTo(38f)
                curveTo(26f, 31.4f, 31.4f, 26f, 38f, 26f)
                close()
            }
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 4f
            ) {
                drawCircle(48f, 48f, 12f)
            }
            path(fill = SolidColor(Color.White)) {
                drawCircle(62f, 34f, 3f)
            }
        }.build()

    val Messenger: ImageVector
        get() = ImageVector.Builder(
            name = "Messenger",
            defaultWidth = 96.dp,
            defaultHeight = 96.dp,
            viewportWidth = 96f,
            viewportHeight = 96f
        ).apply {
            path(fill = SolidColor(Color(0xFF2E89FF))) {
                drawCircle(48f, 48f, 48f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(48f, 22f)
                curveTo(32f, 22f, 20f, 34f, 20f, 48f)
                curveTo(20f, 56f, 24f, 63f, 31f, 68f)
                verticalLineTo(80f)
                lineTo(42f, 74f)
                curveTo(44f, 74f, 46f, 75f, 48f, 75f)
                curveTo(64f, 75f, 76f, 63f, 76f, 49f)
                curveTo(76f, 35f, 64f, 22f, 48f, 22f)
                close()
            }
            path(fill = SolidColor(Color(0xFF2E89FF))) {
                moveTo(36f, 52f)
                lineTo(46f, 42f)
                lineTo(54f, 50f)
                lineTo(64f, 40f)
                lineTo(56f, 54f)
                lineTo(46f, 46f)
                lineTo(36f, 54f)
                close()
            }
        }.build()

    val Telegram: ImageVector
        get() = ImageVector.Builder(
            name = "Telegram",
            defaultWidth = 96.dp,
            defaultHeight = 96.dp,
            viewportWidth = 96f,
            viewportHeight = 96f
        ).apply {
            path(fill = SolidColor(Color(0xFF0E1621))) {
                drawCircle(48f, 48f, 48f)
            }
            path(fill = SolidColor(Color(0xFF12CDD9))) {
                moveTo(72f, 28f)
                lineTo(20f, 48f)
                lineTo(34f, 54f)
                lineTo(38f, 68f)
                lineTo(44f, 60f)
                lineTo(54f, 68f)
                lineTo(72f, 28f)
                close()
            }
        }.build()

    private fun PathBuilder.drawCircle(cx: Float, cy: Float, r: Float) {
        moveTo(cx, cy - r)
        arcTo(r, r, 0f, isMoreThanHalf = true, isPositiveArc = true, cx, cy + r)
        arcTo(r, r, 0f, isMoreThanHalf = true, isPositiveArc = true, cx, cy - r)
        close()
    }
}
