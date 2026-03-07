package com.diegoferreiracaetano.dlearn.designsystem.components.alert

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegoferreiracaetano.dlearn.designsystem.icons.AppIcons
import com.diegoferreiracaetano.dlearn.designsystem.theme.DLearnTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ShareIconSize = 60.dp
private val ShareSpacing = 24.dp
private val ShareTitleTopPadding = 8.dp
private val CloseButtonSize = 32.dp
private val CloseIconSize = 20.dp
private val CloseButtonBackgroundAlpha = 0.2f
private val ShareOptionsSpacing = 16.dp

/**
 * Representa uma opção de compartilhamento.
 */
data class ShareOption(
    val id: String,
    val imageVector: ImageVector,
    val contentDescription: String,
)

/**
 * Configurações padrão e valores utilitários para o [AppShareDialog].
 */
object AppShareDialogDefaults {
    const val DefaultTitle = "Share to"
    const val CloseContentDescription = "Close"

    val SocialOptions = listOf(
        ShareOption(id = "facebook", imageVector = AppIcons.Facebook, contentDescription = "Facebook"),
        ShareOption(id = "instagram", imageVector = AppIcons.Instagram, contentDescription = "Instagram"),
        ShareOption(id = "messenger", imageVector = AppIcons.Messenger, contentDescription = "Messenger"),
        ShareOption(id = "telegram", imageVector = AppIcons.Telegram, contentDescription = "Telegram")
    )

    fun getShareUrl(option: ShareOption, text: String): String? = when (option.id) {
        "facebook" -> "https://www.facebook.com/sharer/sharer.php?u=$text"
        "instagram" -> "https://www.instagram.com/"
        "messenger" -> "fb-messenger://share/?link=$text"
        "telegram" -> "https://t.me/share/url?url=$text"
        else -> null
    }
}

/**
 * Diálogo de compartilhamento genérico.
 *
 * @param onDismissRequest Chamado ao fechar o diálogo.
 * @param options Lista de opções a serem exibidas.
 * @param onOptionClick Callback acionado ao clicar em uma opção.
 * @param modifier Modificador de layout.
 * @param title Título exibido no topo.
 * @param closeContentDescription Descrição de acessibilidade para o botão fechar.
 */
@Composable
fun AppShareDialog(
    onDismissRequest: () -> Unit,
    options: List<ShareOption>,
    onOptionClick: (ShareOption) -> Unit,
    modifier: Modifier = Modifier,
    title: String = AppShareDialogDefaults.DefaultTitle,
    closeContentDescription: String = AppShareDialogDefaults.CloseContentDescription,
) {
    AppDialogContainer(
        onDismissRequest = onDismissRequest,
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = onDismissRequest,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(CloseButtonSize)
                    .background(
                        color = Color.Black.copy(alpha = CloseButtonBackgroundAlpha),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = closeContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(CloseIconSize)
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(ShareTitleTopPadding))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(ShareSpacing))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(ShareOptionsSpacing, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(options, key = { it.id }) { option ->
                        Icon(
                            painter = rememberVectorPainter(option.imageVector),
                            contentDescription = option.contentDescription,
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(ShareIconSize)
                                .clip(CircleShape)
                                .clickable { onOptionClick(option) }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Diálogo de compartilhamento especializado para redes sociais.
 *
 * @param onDismissRequest Chamado ao fechar o diálogo.
 * @param shareText Texto ou URL a ser compartilhado.
 * @param onOptionClick Callback opcional para capturar o clique antes da ação de URI.
 * @param modifier Modificador de layout.
 * @param title Título do diálogo.
 */
@Composable
fun AppSocialShareDialog(
    onDismissRequest: () -> Unit,
    shareText: String,
    onOptionClick: (ShareOption) -> Unit = {},
    modifier: Modifier = Modifier,
    title: String = AppShareDialogDefaults.DefaultTitle,
) {
    val uriHandler = LocalUriHandler.current
    AppShareDialog(
        onDismissRequest = onDismissRequest,
        options = AppShareDialogDefaults.SocialOptions,
        onOptionClick = { option ->
            onOptionClick(option)
            AppShareDialogDefaults.getShareUrl(option, shareText)?.let { url ->
                try {
                    uriHandler.openUri(url)
                } catch (_: Exception) {
                    // Ignora falhas de abertura de URI
                }
            }
        },
        modifier = modifier,
        title = title
    )
}

@Preview
@Composable
fun AppSocialShareDialogPreview() {
    DLearnTheme(darkTheme = true) {
        AppSocialShareDialog(
            onDismissRequest = {},
            shareText = "https://dlearn.com"
        )
    }
}
