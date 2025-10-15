package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.alert.SnackbarType
import com.diegoferreiracaetano.dlearn.designsystem.components.loading.AppLoading

@Composable
fun FeedbackScreen(onShowSnackbar: (String, SnackbarType) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ComponentScaffold(
                title = "AppSnackbar",
                description = "A snackbar for displaying messages.",
                codeSnippet = "onShowSnackbar(\"Message\", SnackbarType.SUCCESS)"
            ) {
                Button(onClick = {
                    onShowSnackbar("This is a success message", SnackbarType.SUCCESS)
                }) {
                    Text("Show Success Snackbar")
                }
                Button(onClick = {
                    onShowSnackbar("This is an error message", SnackbarType.ERROR)
                }) {
                    Text("Show Error Snackbar")
                }
                Button(onClick = {
                    onShowSnackbar("This is a warning message", SnackbarType.WARNING)
                }) {
                    Text("Show Warning Snackbar")
                }
            }
        }
        item {
            ComponentScaffold(
                title = "AppLoading",
                description = "A loading indicator.",
                codeSnippet = "AppLoading()"
            ) {
                AppLoading()
            }
        }
    }
}
