package com.diegoferreiracaetano.dlearn.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

/**
 * A generic wrapper to host any Composable function inside a UIViewController.
 */
fun MakeUIViewController(content: @Composable () -> Unit): UIViewController = ComposeUIViewController { content() }
