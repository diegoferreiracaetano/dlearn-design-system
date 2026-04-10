package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * A custom [LazyColumn] that supports an optional collapsible header.
 * The header hides when scrolling down and shows when scrolling up or reaching the top.
 *
 * @param modifier The [Modifier] to be applied to the list.
 * @param collapsibleContent Optional composable for the header that can be collapsed.
 * @param content The content of the [LazyColumn].
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppList(
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    collapsibleContent: @Composable (() -> Unit)? = null,
    content: LazyListScope.() -> Unit
) {
    var collapsibleContentVisible by remember { mutableStateOf(true) }

    LaunchedEffect(listState) {
        var previousIndex = listState.firstVisibleItemIndex
        var previousOffset = listState.firstVisibleItemScrollOffset

        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .distinctUntilChanged()
            .collect { (currentIndex, currentOffset) ->
                val isScrollingDown = if (currentIndex != previousIndex) {
                    currentIndex > previousIndex
                } else {
                    currentOffset > previousOffset
                }

                val isScrolling = currentIndex != previousIndex || currentOffset != previousOffset
                val isAtTop = currentIndex == 0 && currentOffset == 0

                if (isAtTop) {
                    collapsibleContentVisible = true
                } else if (isScrolling) {
                    collapsibleContentVisible = !isScrollingDown
                }

                previousIndex = currentIndex
                previousOffset = currentOffset
            }
    }

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxWidth()
    ) {
        collapsibleContent?.let { header ->
            stickyHeader {
                AnimatedVisibility(
                    visible = collapsibleContentVisible,
                    enter = expandVertically(),
                    exit = shrinkVertically(),
                ) {
                    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                        header()
                    }
                }
            }
        }

        content()
    }
}
