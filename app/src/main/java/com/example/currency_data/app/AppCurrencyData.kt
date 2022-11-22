package com.example.currency_data.app

import android.app.Application
import com.example.currency_data.di.bookmarksModule
import com.example.currency_data.di.databaseModule
import com.example.currency_data.di.mainScreenModule
import com.example.currency_data.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppCurrencyData : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AppCurrencyData)
            modules(
                networkModule,
                mainScreenModule,
                databaseModule,
                bookmarksModule
            )
        }
    }


}