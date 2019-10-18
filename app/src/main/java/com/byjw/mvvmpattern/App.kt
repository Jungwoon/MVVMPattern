package com.byjw.mvvmpattern

import android.app.Application
import com.byjw.mvvmpattern.model.di.apiModule
import com.byjw.mvvmpattern.model.di.networkModule
import com.byjw.mvvmpattern.model.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(
                apiModule,
                networkModule,
                viewModelModule
            ))
        }

    }
}