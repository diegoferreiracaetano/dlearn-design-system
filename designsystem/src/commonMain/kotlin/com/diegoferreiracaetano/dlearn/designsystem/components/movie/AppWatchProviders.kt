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
import androidx.compose.foundation.shape.RoundedCornerShape
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

data class WatchProvider(
    val name: String,
    val icon: AppImageSource,
    val priceInfo: String,
    val watchUrl: String? = null
)

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
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .animateContentSize()
            .padding(16.dp)
    ) {

        Header(isExpanded, onExpandClick)

        Spacer(Modifier.height(16.dp))

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
                                .width(1.dp)
                                .height(40.dp)
                                .background(
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f)
                                )
                        )

                        Spacer(Modifier.width(12.dp))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                horizontalArrangement = Arrangement.spacedBy((-10).dp)
                            ) {

                                remainingProviders.take(3).forEach {

                                    AppImageCircular(
                                        source = it.icon,
                                        modifier = Modifier
                                            .size(28.dp)
                                            .background(
                                                MaterialTheme.colorScheme.surface,
                                                CircleShape
                                            )
                                            .padding(2.dp)
                                    )
                                }
                            }

                            Spacer(Modifier.height(4.dp))

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
                        modifier = Modifier.padding(vertical = 12.dp),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
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
            .animateContentSize(), // anima deslocamento do conteúdo
        verticalAlignment = Alignment.CenterVertically
    ) {

        AppImageCircular(
            source = provider.icon,
            modifier = Modifier.size(40.dp)
        )

        Spacer(Modifier.width(12.dp))

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

                Spacer(Modifier.width(8.dp))

                AppButton(
                    text = Res.string.action_watch,
                    onClick = onClick,
                    type = ButtonType.SECONDARY,
                    imageSource = Icons.Default.PlayCircleOutline.toAppImageSource(),
                    modifier = Modifier.height(36.dp)
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
            modifier = Modifier.padding(16.dp)
        ) {

            AppWatchProviders(
                providers = providers,
                onProviderClick = {},
                isExpanded = true
            )
        }
    }
}