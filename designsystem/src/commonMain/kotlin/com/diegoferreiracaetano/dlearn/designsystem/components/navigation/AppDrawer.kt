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
import com.github.guilhe.kmp.composeuiviewcontroller.ComposeUIViewController

data class DrawerItem(
    val route: String,
    val icon: ImageVector,
)

@ComposeUIViewController
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
