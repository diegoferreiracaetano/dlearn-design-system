package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.AppDialog
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.SnackbarType
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.feedback.AppFeedback
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.loading.AppLoading
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.DesignSystemRes

@Composable
fun FeedbackScreen(onShowSnackbar: (String, SnackbarType) -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            FeedbackSection("Snackbar Messaging") {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Show Success Snackbar",
                        type = ButtonType.PRIMARY,
                        onClick = { onShowSnackbar("This is a success message", SnackbarType.SUCCESS) }
                    )
                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Show Error Snackbar",
                        type = ButtonType.SECONDARY,
                        onClick = { onShowSnackbar("This is an error message", SnackbarType.ERROR) }
                    )
                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Show Warning Snackbar",
                        type = ButtonType.TERTIARY,
                        onClick = { onShowSnackbar("This is a warning message", SnackbarType.WARNING) }
                    )
                }
            }
        }

        item {
            FeedbackSection("Dialogs") {
                AppButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Show Sample Dialog",
                    type = ButtonType.PRIMARY,
                    onClick = { showDialog = true }
                )
            }
        }

        item {
            FeedbackSection("AppLoading") {
                AppLoading()
            }
        }

        item {
            FeedbackSection("AppFeedback States") {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text("The AppFeedback component is used for empty states, errors, and confirmations.", style = MaterialTheme.typography.bodyMedium)
                    
                    AppFeedback(
                        modifier = Modifier.height(300.dp),
                        title = "No Internet Connection",
                        description = "Please check your network settings and try again.",
                        imageSource = DesignSystemRes.dlearn_logo.toAppImageSource(),
                        primaryText = "Retry",
                        onPrimary = { onShowSnackbar("Retrying...", SnackbarType.SUCCESS) },
                        secondaryText = "Go to Settings",
                        onSecondary = { }
                    )
                }
            }
        }
    }

    if (showDialog) {
        AppDialog(
            onDismissRequest = { showDialog = false },
            title = "Confirm Action",
            description = "Are you sure you want to proceed with this action? This cannot be undone.",
            confirmButtonText = "Confirm",
            onConfirmClick = { 
                showDialog = false
                onShowSnackbar("Action Confirmed", SnackbarType.SUCCESS)
            },
            dismissButtonText = "Cancel",
            onDismissClick = { showDialog = false },
            imageSource = DesignSystemRes.dlearn_logo.toAppImageSource()
        )
    }
}

@Composable
private fun FeedbackSection(title: String, content: @Composable () -> Unit) {
    Column {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        content()
        HorizontalDivider(modifier = Modifier.padding(top = 24.dp))
    }
}
