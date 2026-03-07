package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlinx.coroutines.CoroutineScope
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppSnackbarHostTest {

    @Test
    fun shouldDisplaySnackbarWhenMessageIsShown() = runComposeUiTest {
        val snackbarHostState = SnackbarHostState()
        val message = "Success message"
        
        var scope: CoroutineScope? = null
        
        setContent {
            scope = rememberCoroutineScope()
            AppSnackbarHost(hostState = snackbarHostState)
        }

        scope?.let { s ->
            snackbarHostState.showAppSnackBar(
                scope = s,
                message = message,
                type = SnackbarType.SUCCESS
            )
        }
        
        // Wait for the snackbar to appear. 
        // We use substring = true because AppSnackbarHost displays "SUCCESS: Success message"
        waitUntil(timeoutMillis = 5000) {
            onAllNodesWithText(message, substring = true, ignoreCase = true).fetchSemanticsNodes().isNotEmpty()
        }
        
        onNodeWithText(message, substring = true, ignoreCase = true).assertIsDisplayed()
    }
}
