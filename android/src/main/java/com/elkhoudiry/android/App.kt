@file:Suppress("unused")

package com.elkhoudiry.android

import android.app.Application
import com.elkhoudiry.android.injections.viewModels
import com.elkhoudiry.di.sqlDelightModule
import com.elkhoudiry.di.uiModules
import com.elkhoudiry.ui.app.CommonGlobals
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        CommonGlobals.resContext = this

        startKoin {
            androidContext(this@App)

            modules(
                uiModules,
                viewModels,
                sqlDelightModule
            )
        }
    }
}
