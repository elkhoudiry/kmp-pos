import androidx.compose.runtime.collectAsState
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.elkhoudiry.di.Inject
import com.elkhoudiry.di.platformViewModelsModule
import com.elkhoudiry.di.uiModules
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.destinations.MainScreen
import com.elkhoudiry.ui.destinations.MenuScreen
import com.elkhoudiry.ui.destinations.WarehousesScreen
import org.koin.core.context.startKoin

fun main() = application {
    CommonGlobals.resContext = Unit

    startKoin {
        modules(
            uiModules,
            platformViewModelsModule
        )
    }

    val nav = Inject.navRepository()

    Window(
        onCloseRequest = ::exitApplication,
        title = "POS"
    ) {
        when (
            nav
                .listen()
                .collectAsState(NavDestination.Main).value
        ) {
            NavDestination.Main -> {
                MainScreen(
                    navigationRepository = nav
                )
            }

            NavDestination.Menu -> {
                MenuScreen(
                    menuViewModel = Inject.menuPlatformViewModel(),
                    checkoutViewModel = Inject.checkoutPlatformViewModel(),
                    navRepository = nav,
                )
            }

            NavDestination.WareHouses -> {
                WarehousesScreen(
                    warehousesViewModel = Inject.warehousesPlatformViewModel(),
                    navigationRepository = nav
                )
            }

            NavDestination.NONE -> {
            }
        }
    }
}
