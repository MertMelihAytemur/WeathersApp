package tr.com.mermela.weathersapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 *Created by Mert Melih Aytemur on 2/11/2024.
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@Application)
            // Load modules
            modules()
        }
    }
}