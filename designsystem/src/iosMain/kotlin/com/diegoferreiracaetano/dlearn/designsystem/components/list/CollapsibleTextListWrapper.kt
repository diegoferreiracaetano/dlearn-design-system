package com.diegoferreiracaetano.dlearn.designsystem.components.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChip
import com.diegoferreiracaetano.dlearn.designsystem.components.chip.AppChipGroup
import platform.UIKit.UIViewController

/**
 * A specific Composable that implements AppList with a collapsible ChipGroup
 * and a list of simple text items.
 */
@Composable
private fun CollapsibleTextList(
    modifier: Modifier = Modifier,
    chips: List<AppChip>,
    onFilterChanged: (String?) -> Unit,
    items: List<String>
) {
    AppList(
        modifier = modifier,
        collapsibleContent = {
            AppChipGroup(
                items = chips,
                onFilterChanged = onFilterChanged
            )
        }
    ) {
        items(items.size) { index ->
            Text(
                text = items[index],
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

/**
 * The UIViewController factory for the CollapsibleTextList.
 */
object CollapsibleTextListUIViewController {
    operator fun invoke(
        modifier: Modifier = Modifier,
        chips: List<AppChip>,
        onFilterChanged: (String?) -> Unit,
        items: List<String>
    ): UIViewController {
        return ComposeUIViewController {
            CollapsibleTextList(
                modifier = modifier,
                chips = chips,
                onFilterChanged = onFilterChanged,
                items = items
            )
        }
    }
}
