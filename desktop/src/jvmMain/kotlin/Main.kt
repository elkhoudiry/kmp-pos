import androidx.compose.runtime.collectAsState
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.elkhoudiry.di.Inject
import com.elkhoudiry.domain.navigation.models.NavDestination
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.app.menuModule
import com.elkhoudiry.ui.destinations.MainScreen
import com.elkhoudiry.ui.destinations.MenuScreen
import com.elkhoudiry.ui.destinations.WarehousesScreen
import com.elkhoudiry.ui.viewmodels.CheckoutPlatformViewModel
import com.elkhoudiry.ui.viewmodels.MenuPlatformViewModel
import com.elkhoudiry.ui.viewmodels.WarehousesPlatformViewModel
import org.koin.core.context.startKoin

fun main() = application {
    CommonGlobals.resContext = Unit

    startKoin {
        modules(menuModule)
    }

    val nav = Inject.navRepository()

    val menuViewModel = MenuPlatformViewModel(Inject.menuViewModel())
    val checkoutViewModel = CheckoutPlatformViewModel(Inject.checkoutViewModel())
    val warehousesViewModel = WarehousesPlatformViewModel(Inject.warehousesViewModel())

    Window(onCloseRequest = ::exitApplication, title = "POS") {
        when (nav.listen().collectAsState(NavDestination.Main).value) {
            NavDestination.Main -> {
                MainScreen(
                    navigationRepository = nav
                )
            }
            NavDestination.Menu -> {
                MenuScreen(
                    menuViewModel = menuViewModel,
                    checkoutViewModel = checkoutViewModel,
                    navRepository = nav,
                )
            }
            NavDestination.WareHouses -> {
                WarehousesScreen(
                    warehousesViewModel = warehousesViewModel, navigationRepository = nav
                )
            }
            NavDestination.NONE -> {

            }
        }
    }
}
