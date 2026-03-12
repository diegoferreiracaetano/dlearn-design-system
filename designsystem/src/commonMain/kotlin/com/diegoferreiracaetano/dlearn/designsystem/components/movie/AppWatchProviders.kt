package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_watch
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_netflix
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.movie_where_to_watch
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.movie_watch_provider_more
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Data class representing a watch provider (streaming service).
 *
 * @property name The name of the streaming service (e.g., "Netflix").
 * @property icon The icon of the streaming service.
 * @property priceInfo Information about the pricing or availability (e.g., "Subscription").
 * @property watchUrl The direct URL to watch the content on this provider (optional).
 */
data class WatchProvider(
    val name: String,
    val icon: AppImageSource,
    val priceInfo: String,
    val watchUrl: String? = null
)

private val ContainerPadding = 16.dp
private val HeaderSpacing = 16.dp
private val ProviderIconSize = 40.dp
private val SummaryIconSize = 28.dp
private val SummaryIconPadding = 2.dp
private val SummaryIconOverlap = (-10).dp
private val ContentSpacing = 12.dp
private val DividerVerticalPadding = 12.dp
private val WatchButtonHeight = 36.dp
private val SummaryDividerWidth = 1.dp
private val SummaryDividerHeight = 40.dp
private val SummaryTextSpacing = 4.dp
private val ProviderActionSpacing = 8.dp
private const val BackgroundAlpha = 0.5f
private const val DividerAlpha = 0.1f
private const val SummaryDividerAlpha = 0.15f
private const val SummaryVisibleCount = 3

/**
 * A component that displays a list of watch providers where a movie can be streamed.
 * It features a collapsible design that shows a primary provider and a summary of others
 * when collapsed, and a full list when expanded.
 *
 * @param providers The list of [WatchProvider] objects to display.
 * @param onProviderClick Callback invoked when a provider is clicked.
 * @param modifier The [Modifier] to be applied to this component.
 * @param isExpanded Whether the component is currently expanded to show all providers.
 * @param onExpandClick Callback invoked when the expand/collapse header or summary is clicked.
 */
@Composable
fun AppWatchProviders(
    providers: List<WatchProvider>,
    onProviderClick: (WatchProvider) -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onExpandClick: () -> Unit = {}
) {
    val firstProvider = providers.firstOrNull()
    val remainingProviders = providers.drop(1)

    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = BackgroundAlpha))
            .animateContentSize()
            .padding(ContainerPadding)
    ) {
        Header(isExpanded, onExpandClick)

        Spacer(Modifier.height(HeaderSpacing))

        if (firstProvider != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    WatchProviderItem(
                        provider = firstProvider,
                        showWatchButton = isExpanded,
                        onClick = { onProviderClick(firstProvider) }
                    )
                }

                AnimatedVisibility(
                    visible = !isExpanded && remainingProviders.isNotEmpty()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable { onExpandClick() }
                    ) {
                        Box(
                            modifier = Modifier
                                .width(SummaryDividerWidth)
                                .height(SummaryDividerHeight)
                                .background(
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = SummaryDividerAlpha)
                                )
                        )

                        Spacer(Modifier.width(ContentSpacing))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(SummaryIconOverlap)
                            ) {
                                remainingProviders.take(SummaryVisibleCount).forEach {
                                    AppImageCircular(
                                        source = it.icon,
                                        modifier = Modifier
                                            .size(SummaryIconSize)
                                            .background(
                                                MaterialTheme.colorScheme.surface,
                                                CircleShape
                                            )
                                            .padding(SummaryIconPadding)
                                    )
                                }
                            }

                            Spacer(Modifier.height(SummaryTextSpacing))

                            Text(
                                text = stringResource(
                                    Res.string.movie_watch_provider_more,
                                    remainingProviders.size
                                ),
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = isExpanded
        ) {
            Column {
                remainingProviders.forEach {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = DividerVerticalPadding),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = DividerAlpha)
                    )

                    WatchProviderItem(
                        provider = it,
                        showWatchButton = isExpanded,
                        onClick = { onProviderClick(it) }
                    )
                }
            }
        }
    }
}

/**
 * Header of the [AppWatchProviders] component containing the title and an expand/collapse icon.
 */
@Composable
private fun Header(
    isExpanded: Boolean,
    onExpandClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onExpandClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(Res.string.movie_where_to_watch),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Icon(
            imageVector = if (isExpanded)
                Icons.Default.KeyboardArrowUp
            else
                Icons.Default.KeyboardArrowDown,
            contentDescription = null
        )
    }
}

/**
 * Individual provider item within the [AppWatchProviders] list.
 */
@Composable
private fun WatchProviderItem(
    provider: WatchProvider,
    onClick: () -> Unit,
    showWatchButton: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .animateContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppImageCircular(
            source = provider.icon,
            modifier = Modifier.size(ProviderIconSize)
        )

        Spacer(Modifier.width(ContentSpacing))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = provider.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = provider.priceInfo,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        AnimatedVisibility(
            visible = showWatchButton,
            enter = fadeIn() + expandHorizontally(expandFrom = Alignment.End),
            exit = fadeOut() + shrinkHorizontally(shrinkTowards = Alignment.End)
        ) {
            Row {
                Spacer(Modifier.width(ProviderActionSpacing))

                AppButton(
                    text = Res.string.action_watch,
                    onClick = onClick,
                    type = ButtonType.SECONDARY,
                    imageSource = Icons.Default.PlayCircleOutline.toAppImageSource(),
                    modifier = Modifier.height(WatchButtonHeight)
                )
            }
        }
    }
}

@Preview
@Composable
fun AppWatchProvidersPreview() {
    val providers = listOf(
        WatchProvider("Mercado Play", Res.drawable.ic_netflix.toAppImageSource(), "Sem custo financeiro"),
        WatchProvider("Netflix", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura"),
        WatchProvider("Amazon Prime Video", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura"),
        WatchProvider("Google TV", Res.drawable.ic_netflix.toAppImageSource(), "A partir de R$ 6,90"),
        WatchProvider("Apple TV", Res.drawable.ic_netflix.toAppImageSource(), "A partir de R$ 11,90")
    )

    DLearnTheme {
        Column(
            modifier = Modifier.padding(ContainerPadding)
        ) {
            AppWatchProviders(
                providers = providers,
                onProviderClick = {},
                isExpanded = true
            )
        }
    }
}
