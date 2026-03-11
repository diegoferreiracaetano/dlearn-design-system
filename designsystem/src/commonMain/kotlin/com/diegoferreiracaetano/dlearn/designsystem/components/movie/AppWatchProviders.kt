package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegoferreiracaetano.dlearn.designsystem.components.button.AppButton
import com.diegoferreiracaetano.dlearn.designsystem.components.button.ButtonType
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageCircular
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.action_watch
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_netflix
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.movie_watch_provider_more
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.movie_where_to_watch
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

data class WatchProvider(
    val name: String,
    val icon: AppImageSource,
    val priceInfo: String,
    val watchUrl: String? = null
)

/**
 * A component that displays a list of watch providers for a movie.
 * Can be expanded or collapsed to show more/less details.
 *
 * @param providers List of [WatchProvider] to display.
 * @param onProviderClick Callback when a provider is clicked.
 * @param modifier Modifier for the container.
 * @param isExpanded Whether the component is expanded.
 * @param onExpandClick Callback when the expansion state should toggle.
 */
@Composable
fun AppWatchProviders(
    providers: List<WatchProvider>,
    onProviderClick: (WatchProvider) -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onExpandClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .padding(12.dp)
            .heightIn(min = 56.dp)
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
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            IconButton(
                onClick = onExpandClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                ),
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        AnimatedContent(
            targetState = isExpanded,
            transitionSpec = {
                if (targetState > initialState) {
                    (slideInVertically { height -> height } + fadeIn() togetherWith
                            slideOutVertically { height -> -height } + fadeOut())
                } else {
                    (slideInVertically { height -> -height } + fadeIn() togetherWith
                            slideOutVertically { height -> height } + fadeOut())
                }.using(
                    SizeTransform(clip = false)
                )
            },
            label = "WatchProvidersExpansion"
        ) { expanded ->
            if (expanded) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    providers.forEachIndexed { index, provider ->
                        WatchProviderItem(
                            provider = provider,
                            onClick = { onProviderClick(provider) }
                        )
                        if (index < providers.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 8.dp),
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                            )
                        }
                    }
                }
            } else {
                WatchProvidersCollapsed(
                    providers = providers,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun WatchProvidersCollapsed(
    providers: List<WatchProvider>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (providers.isNotEmpty()) {
            val first = providers.first()
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AppImageCircular(
                    source = first.icon,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = first.name,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = first.priceInfo,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            if (providers.size > 1) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .width(1.dp)
                        .height(32.dp)
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy((-10).dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        providers.drop(1).take(3).forEach { provider ->
                            AppImageCircular(
                                source = provider.icon,
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(MaterialTheme.colorScheme.surface, CircleShape)
                                    .padding(1.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(Res.string.movie_watch_provider_more, providers.size - 1),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
private fun WatchProviderItem(
    provider: WatchProvider,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppImageCircular(
            source = provider.icon,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = provider.name,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = provider.priceInfo,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        AppButton(
            text = Res.string.action_watch,
            onClick = onClick,
            type = ButtonType.SECONDARY,
            imageSource = Icons.Default.PlayCircleOutline.toAppImageSource(),
            modifier = Modifier.width(110.dp).height(36.dp)
        )
    }
}

@Preview
@Composable
fun AppWatchProvidersPreview() {
    val providers = listOf(
        WatchProvider("Mercado Play", Res.drawable.ic_netflix.toAppImageSource(), "Sem custo financeiro"),
        WatchProvider("Netflix", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura"),
        WatchProvider("Amazon Prime Video", Res.drawable.ic_netflix.toAppImageSource(), "Assinatura (Exige complemento)"),
        WatchProvider("Google TV", Res.drawable.ic_netflix.toAppImageSource(), "A partir de R$ 6,90"),
        WatchProvider("Apple TV", Res.drawable.ic_netflix.toAppImageSource(), "A partir de R$ 11,90")
    )
    DLearnTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            AppWatchProviders(
                providers = providers,
                onProviderClick = {},
                isExpanded = true
            )
        }
    }
}
