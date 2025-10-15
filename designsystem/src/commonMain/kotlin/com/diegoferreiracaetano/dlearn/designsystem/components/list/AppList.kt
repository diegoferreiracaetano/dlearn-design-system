package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChip
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipGroup
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlinx.coroutines.flow.distinctUntilChanged
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppList(
    modifier: Modifier = Modifier,
    collapsibleContent: @Composable (() -> Unit)? = null,
    content: LazyListScope.() -> Unit
) {

    val listState = rememberLazyListState()
    var collapsibleContentVisible by remember { mutableStateOf(true) }

    LaunchedEffect(listState) {
        var previousState =
            listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset

        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .distinctUntilChanged()
            .collect { currentState ->
                val (previousIndex, previousOffset) = previousState
                val (currentIndex, currentOffset) = currentState

                val isScrollingDown = if (previousIndex != currentIndex) {
                    currentIndex > previousIndex
                } else {
                    currentOffset > previousOffset
                }

                collapsibleContentVisible =
                    !(isScrollingDown && (currentIndex > 0 || currentOffset > 0))

                @Suppress("UNUSED_ASSIGNMENT")
                previousState = currentState
            }
    }

    LazyColumn(
        state = listState,
        modifier = modifier
            .fillMaxWidth()
    ) {
        collapsibleContent?.let {
            stickyHeader {
                AnimatedVisibility(
                    visible = collapsibleContentVisible,
                    enter = slideInVertically(initialOffsetY = { -it }),
                    exit = slideOutVertically(targetOffsetY = { -it }),
                ) {
                    Box(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
                        it()
                    }
                }
            }
        }

        content()
    }
}

@Composable
@Preview
fun AppListPreview() {
    DLearnTheme {
        AppList(
            collapsibleContent = {
                AppChipGroup(
                    items = listOf(
                        AppChip(
                            label = "Séries"
                        ),
                        AppChip(
                            label = "Filmes"
                        ),
                        AppChip(
                            label = "Categorias",
                            hasDropDown = true,
                            isFilter = false
                        )
                    ),
                    onFilterChanged = {}
                )
            }
        ) {
            items(100) { index ->
                Text(
                    text = "Item $index",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

