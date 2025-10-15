package com.diegoferreiracaetano.dlearn.designsystem.components.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Fireplace
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Fireplace
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import com.diegoferreiracaetano.dlearn.designsystem.util.isIOS
import org.jetbrains.compose.ui.tooling.preview.Preview

private val NavBarHeightSingleLine = 80.dp
private val NavBarHeightTwoLines = 90.dp
private val NavBarIosInsets = 28.dp

data class AppBottomNavigation(
    val selectedRoute: String = tabList.first().route,
    val items: List<AppNavigationTab> = tabList,
    val onTabSelected: (String) -> Unit,
)

data class AppNavigationTab(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Composable
fun AppBottomNavigationBar(
    modifier: Modifier = Modifier,
    items: List<AppNavigationTab>,
    selectedRoute: String,
    onTabSelected: (String) -> Unit,
) {
    NavigationBar(
        modifier = modifier.height(if (isIOS) NavBarHeightTwoLines else NavBarHeightSingleLine),
        windowInsets =
        if (isIOS) WindowInsets(bottom = NavBarIosInsets) else NavigationBarDefaults.windowInsets
    ) {
        val customColors: NavigationBarItemColors = NavigationBarItemDefaults.colors(
            indicatorColor = Color.Transparent
        )

        items.forEach { tab ->
            val isSelected = tab.route == selectedRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { if (!isSelected) onTabSelected(tab.route) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
                        contentDescription = tab.label,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                label = {
                    Text(
                        text = tab.label,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = if (isSelected) {
                            MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.ExtraBold)
                        } else {
                            MaterialTheme.typography.labelSmall
                        },
                    )
                },
                colors = customColors
            )
        }
    }
}

private enum class TabItem(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    Home("Home", "Home", Icons.Filled.Home, Icons.Outlined.Home),
    New(
        "New",
        "Novidades",
        Icons.Filled.Fireplace,
        Icons.Outlined.Fireplace
    ),
    Favorites(
        "Favorites",
        "Favoritos",
        Icons.Filled.Favorite,
        Icons.Outlined.FavoriteBorder
    ),
    Account(
        "Account",
        "Conta",
        Icons.Filled.AccountCircle,
        Icons.Outlined.AccountCircle
    )
}

private val tabList = TabItem.entries.map {
    AppNavigationTab(
        route = it.route,
        label = it.label,
        selectedIcon = it.selectedIcon,
        unselectedIcon = it.unselectedIcon
    )
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    DLearnTheme {
        AppBottomNavigationBar(
            items = tabList,
            selectedRoute = "Home",
            onTabSelected = {}
        )
    }
}
