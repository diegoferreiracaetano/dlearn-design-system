package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppCarousel(
    pageCount: Int,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState { pageCount },
    showIndicator: Boolean = true,
    pageContent: @Composable (pageIndex: Int) -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        HorizontalPager(state = pagerState) { pageIndex ->
            pageContent(pageIndex)
        }

        if (showIndicator && pageCount > 1) {
            PageIndicator(
                totalPages = pageCount,
                currentPage = pagerState.currentPage,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
            )
        }
    }
}
