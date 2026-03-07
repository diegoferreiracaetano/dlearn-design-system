package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A generic carousel component that supports both paging (one item at a time)
 * and standard horizontal scrolling (list of items).
 *
 * @param itemCount The total number of items in the carousel.
 * @param modifier The modifier to be applied to the carousel container.
 * @param title Optional title displayed above the carousel.
 * @param isPager If true, uses a [HorizontalPager] for snapping behavior. If false, uses a [LazyRow].
 * @param spacing The spacing between items.
 * @param contentPadding The padding to be applied around the content.
 * @param pagerState The state for the pager (only used if [isPager] is true).
 * @param showIndicator If true, shows a page indicator (only used if [isPager] is true).
 * @param itemContent The composable content for each item.
 */
@Composable
fun AppCarousel(
    itemCount: Int,
    modifier: Modifier = Modifier,
    title: String? = null,
    isPager: Boolean = true,
    spacing: Dp = if (isPager) 0.dp else 8.dp,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    pagerState: PagerState = rememberPagerState { itemCount },
    showIndicator: Boolean = isPager,
    itemContent: @Composable (index: Int) -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            )
        }

        if (isPager) {
            Box(modifier = Modifier.fillMaxWidth()) {
                HorizontalPager(
                    state = pagerState,
                    contentPadding = contentPadding,
                    pageSpacing = spacing,
                ) { index ->
                    itemContent(index)
                }

                if (showIndicator && (itemCount > 1)) {
                    PageIndicator(
                        totalPages = itemCount,
                        currentPage = pagerState.currentPage,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 8.dp),
                    )
                }
            }
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(spacing),
                contentPadding = contentPadding,
                modifier = Modifier.fillMaxWidth(),
            ) {
                items(itemCount) { index ->
                    itemContent(index)
                }
            }
        }
    }
}
