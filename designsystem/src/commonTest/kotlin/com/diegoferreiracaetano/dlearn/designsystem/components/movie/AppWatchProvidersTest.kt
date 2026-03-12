package com.diegoferreiracaetano.dlearn.designsystem.components.movie

import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.Res
import com.diegoferreiracaetano.dlearn.designsystem.generated.resources.ic_netflix
import com.diegoferreiracaetano.dlearn.designsystem.components.image.toAppImageSource
import kotlin.test.Test
import kotlin.test.assertEquals

class AppWatchProvidersTest {

    @Test
    fun testWatchProviderDataClass() {
        val name = "Netflix"
        val priceInfo = "Subscription"
        val watchUrl = "https://www.netflix.com"
        val icon = Res.drawable.ic_netflix.toAppImageSource()

        val provider = WatchProvider(
            name = name,
            icon = icon,
            priceInfo = priceInfo,
            watchUrl = watchUrl
        )

        assertEquals(name, provider.name)
        assertEquals(priceInfo, provider.priceInfo)
        assertEquals(watchUrl, provider.watchUrl)
        assertEquals(icon, provider.icon)
    }

    @Test
    fun testWatchProviderListSplitting() {
        val providers = listOf(
            WatchProvider("P1", Res.drawable.ic_netflix.toAppImageSource(), "Free"),
            WatchProvider("P2", Res.drawable.ic_netflix.toAppImageSource(), "Sub"),
            WatchProvider("P3", Res.drawable.ic_netflix.toAppImageSource(), "Rent")
        )

        val first = providers.firstOrNull()
        val remaining = providers.drop(1)

        assertEquals("P1", first?.name)
        assertEquals(2, remaining.size)
        assertEquals("P2", remaining[0].name)
    }
}
