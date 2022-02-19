package com.elkhoudiry.android

import android.app.Application
import com.elkhoudiry.android.injections.viewModels
import com.elkhoudiry.ui.app.CommonGlobals
import com.elkhoudiry.ui.app.menuModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        CommonGlobals.resContext = this

        startKoin {
            modules(menuModule, viewModels)
        }
    }
}