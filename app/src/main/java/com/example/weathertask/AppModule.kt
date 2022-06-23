package com.example.weathertask

import com.example.weathertask.data.network.ConnectivityInterceptor
import com.example.weathertask.data.network.ConnectivityInterceptorImpl
import org.koin.dsl.module

val applicationModule = module{

    single<ConnectivityInterceptor> {
        ConnectivityInterceptorImpl(
            context = get()
        )
    }
}
