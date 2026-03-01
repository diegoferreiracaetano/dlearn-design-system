package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * Data class representing an item in the navigation drawer.
 *
 * @property route The route identifier for this item.
 * @property icon The [ImageVector] to be displayed as an icon.
 */
data class DrawerItem(
    val route: String,
    val icon: ImageVector,
)

/**
 * A custom navigation drawer content component.
 *
 * @param items The list of [DrawerItem] to be displayed in the drawer.
 * @param selectedRoute The route of the currently selected item.
 * @param onItemSelected Callback invoked when an item is clicked.
 * @param modifier The [Modifier] to be applied to the drawer content.
 */
@Composable
fun AppDrawer(
    items: List<DrawerItem>,
    selectedRoute: String,
    onItemSelected: (DrawerItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .padding(16.dp)
        .padding(top = 60.dp)
    ) {
        items.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item.route) },
                icon = { Icon(item.icon, contentDescription = item.route) },
                selected = item.route == selectedRoute,
                onClick = { onItemSelected(item) },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}
