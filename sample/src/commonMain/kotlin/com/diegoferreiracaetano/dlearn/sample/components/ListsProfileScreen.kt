package com.diegoferreiracaetano.dlearn.sample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import com.diegoferreiracaetano.dlearn.designsystem.components.list.AppSectionTitle
import com.diegoferreiracaetano.dlearn.designsystem.components.list.AppTextRow
import com.diegoferreiracaetano.dlearn.designsystem.components.profile.AppProfileHeader
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.DesignSystemRes

@Composable
fun ListsProfileScreen() {
    var notificationsEnabled by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AppProfileHeader(
            name = "Diego Caetano",
            email = "diego@dlearn.com",
            imageSource = DesignSystemRes.profile.toAppImageSource(),
            onEditClick = { /* Ação de editar */ }
        )

        Column(modifier = Modifier.padding(16.dp)) {
            AppSectionTitle(title = "Informações Pessoais")
            
            AppTextRow(
                label = "Nome",
                value = "Diego Caetano",
                leadingIcon = Icons.Default.Person,
                onClick = {}
            )

            AppTextRow(
                label = "E-mail",
                value = "diego@dlearn.com",
                leadingIcon = Icons.Default.Email,
                onClick = {}
            )

            AppSectionTitle(title = "Configurações")

            AppTextRow(
                label = "Notificações",
                leadingIcon = Icons.Default.Notifications,
                isEnabled = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it }
            )

            AppTextRow(
                label = "Alterar Senha",
                leadingIcon = Icons.Default.Lock,
                trailingIcon = Icons.Default.ChevronRight,
                onClick = {}
            )
        }
    }
}
