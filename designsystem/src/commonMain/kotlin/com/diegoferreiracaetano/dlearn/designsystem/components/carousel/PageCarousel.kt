package com.diegoferreiracaetano.dlearn.designsystem.components.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_arrow_right
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

const val PAGE_CAROUSEL_NEXT_BUTTON_TAG = "PageCarouselNextButton"

@Composable
fun PageCarousel(
    pageCount: Int,
    onFinish: () -> Unit,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState { pageCount },
    imageContent: @Composable (pageIndex: Int) -> Unit,
    infoContent: @Composable (pageIndex: Int) -> Unit,
) {
    val scope = rememberCoroutineScope()

    Box(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        AppCarousel(
            itemCount = pageCount,
            pagerState = pagerState,
            showIndicator = false,
            modifier = Modifier.fillMaxSize(),
            itemContent = imageContent
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
                .shadow(
                    elevation = 4.dp,
                    shape = MaterialTheme.shapes.extraLarge,
                    clip = false
                )
                .clip(MaterialTheme.shapes.extraLarge)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.95f))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            infoContent(pagerState.currentPage)

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                PageIndicator(
                    totalPages = pageCount,
                    currentPage = pagerState.currentPage,
                )

                AppButton(
                    onClick = {
                        if (pagerState.currentPage < (pageCount - 1)) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            onFinish()
                        }
                    },
                    image = Res.drawable.ic_arrow_right,
                    modifier = Modifier.size(56.dp).testTag(PAGE_CAROUSEL_NEXT_BUTTON_TAG),
                )
            }
        }
    }
}

@Preview
@Composable
fun OnboardingCarouselPreview() {
    DLearnTheme {
        PageCarousel(
            pageCount = 3,
            onFinish = {},
            imageContent = {
                Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surfaceVariant))
            },
            infoContent = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Title $it",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Description for page $it",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        )
    }
}
