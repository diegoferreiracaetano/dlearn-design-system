package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.banner.AppBanner
import com.diegoferreiracaetano.dlearn.designsystem.components.image.AppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.profile.AppProfileHeader
import com.diegoferreiracaetano.dlearn.designsystem.components.profile.AppProfileRow
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.app_name
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.title_email
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.title_name
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.title_password
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import kotlinx.coroutines.flow.distinctUntilChanged
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Interface representing an item that can be displayed in an [AppList].
 */
sealed interface AppListItem

/**
 * A section title item for the list.
 */
data class SectionTitleItem(val title: StringResource) : AppListItem

/**
 * A row item with a label and optional value/switcher.
 */
data class TextRowItem(
    val label: StringResource,
    val valueString: String? = null,
    val value: StringResource? = null,
    val leadingIcon: ImageVector? = null,
    val isEnabled: Boolean = false,
    val onClick: (() -> Unit)? = null,
    val onCheckedChange: ((Boolean) -> Unit)? = null
) : AppListItem

/**
 * A profile row item with user info.
 */
data class ProfileItem(
    val title: String,
    val description: String,
    val imageSource: AppImageSource? = null,
    val onEditClick: (() -> Unit)? = null
) : AppListItem

/**
 * A profile header item with centered user info.
 */
data class ProfileHeaderItem(
    val name: String,
    val email: String,
    val imageSource: AppImageSource? = null,
    val onEditClick: (() -> Unit)? = null
) : AppListItem

/**
 * A banner item for announcements.
 */
data class BannerItem(
    val title: String,
    val description: String,
    val icon: ImageVector? = null
) : AppListItem

/**
 * A custom composable item for the list.
 */
data class CustomItem(val content: @Composable () -> Unit) : AppListItem

/**
 * A custom [LazyColumn] that supports an optional collapsible header.
 * The header hides when scrolling down and shows when scrolling up or reaching the top.
 *
 * @param modifier The [Modifier] to be applied to the list.
 * @param collapsibleContent Optional composable for the header that can be collapsed.
 * @param content The content of the [LazyColumn].
 */
@Composable
fun AppList(
    modifier: Modifier = Modifier,
    collapsibleContent: @Composable (() -> Unit)? = null,
    content: LazyListScope.() -> Unit
) {
    val listState = rememberLazyListState()
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

                // Show if at the top or scrolling up, hide if scrolling down
                collapsibleContentVisible = currentIndex == 0 || !isScrollingDown

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

/**
 * A simplified version of [AppList] that takes a list of [AppListItem]s.
 *
 * @param items The list of items to display.
 * @param modifier The [Modifier] to be applied to the list.
 * @param collapsibleContent Optional composable for the header that can be collapsed.
 */
@Composable
fun AppList(
    items: List<AppListItem>,
    modifier: Modifier = Modifier,
    collapsibleContent: @Composable (() -> Unit)? = null,
) {
    AppList(
        modifier = modifier,
        collapsibleContent = collapsibleContent
    ) {
        items(items) { item ->
            when (item) {
                is SectionTitleItem -> AppSectionTitle(title = item.title)
                is TextRowItem -> {
                    if (item.value != null) {
                        AppTextRow(
                            label = item.label,
                            value = item.value,
                            leadingIcon = item.leadingIcon,
                            isEnabled = item.isEnabled,
                            onClick = item.onClick,
                            onCheckedChange = item.onCheckedChange
                        )
                    } else {
                        AppTextRow(
                            label = item.label,
                            valueString = item.valueString,
                            leadingIcon = item.leadingIcon,
                            isEnabled = item.isEnabled,
                            onClick = item.onClick,
                            onCheckedChange = item.onCheckedChange
                        )
                    }
                }

                is ProfileItem -> AppProfileRow(
                    name = item.title,
                    email = item.description,
                    imageSource = item.imageSource,
                    onEditClick = item.onEditClick
                )

                is ProfileHeaderItem -> AppProfileHeader(
                    name = item.name,
                    email = item.email,
                    imageSource = item.imageSource,
                    onEditClick = item.onEditClick
                )

                is BannerItem -> AppBanner(
                    title = item.title,
                    description = item.description,
                    icon = item.icon
                )

                is CustomItem -> item.content()
            }
        }
    }
}

@Preview
@Composable
private fun AppProfileAndListPreview() {
    DLearnTheme(darkTheme = true) {
        val items = listOf(
            ProfileHeaderItem(
                name = "Tiffany",
                email = "Tiffanyjearsey@gmail.com",
                onEditClick = {}
            ),
            BannerItem(
                title = "Premium Member",
                description = "New movies are coming for you, Download Now!",
                icon = Icons.Default.WorkspacePremium
            ),
            SectionTitleItem(title = Res.string.title_name),
            TextRowItem(
                label = Res.string.title_email,
                leadingIcon = Icons.Default.AccountCircle,
                onClick = {}
            ),
            TextRowItem(
                label = Res.string.title_password,
                leadingIcon = Icons.Default.Lock,
                onClick = {}
            ),
            SectionTitleItem(title = Res.string.app_name),
            TextRowItem(
                label = Res.string.title_name,
                leadingIcon = Icons.Default.Notifications,
                onCheckedChange = {},
                isEnabled = true
            )
        )

        AppList(
            items = items,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
        )
    }
}
