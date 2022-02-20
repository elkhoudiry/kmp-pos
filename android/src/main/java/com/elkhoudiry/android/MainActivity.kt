package com.elkhoudiry.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.elkhoudiry.domain.MR
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.domain.navigation.repositories.BaseNavigationRepository
import com.elkhoudiry.ui.destinations.MainScreen
import com.elkhoudiry.ui.destinations.MenuScreen
import com.elkhoudiry.ui.destinations.WarehousesScreen
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navRepo: BaseNavigationRepository by inject()

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            when (navRepo.listen().collectAsState(NavDestination.Main).value) {
                NavDestination.Main -> {
                    MainScreen(navRepo)
                }
                NavDestination.Menu -> {
                    MenuScreen(get(), get(), get())
                }
                NavDestination.WareHouses -> {
                    WarehousesScreen(get(), get())
                }
                NavDestination.NONE -> {
                }
            }

            Log.d("TAGGY", "sell: >>> ${StringDesc.Resource(MR.strings.sell).toString(this)} <<<")
        }
    }
}
