package com.example.weathertask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class WeatherTaskApplication : Application() {

    val modules: List<Module> = listOf(
        applicationModule, viewmodelModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherTaskApplication)
            modules(modules)
        }

    }
}