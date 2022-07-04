package com.example.weathertask

import com.example.weathertask.data.ApixuWeatherApiService
import com.example.weathertask.data.network.ConnectivityInterceptor
import com.example.weathertask.data.network.ConnectivityInterceptorImpl
import com.example.weathertask.data.network.WeatherNetworkDataSource
import com.example.weathertask.data.network.WeatherNetworkDataSourceImpl
import org.koin.dsl.module

val applicationModule = module{

    single<ConnectivityInterceptor> {
        ConnectivityInterceptorImpl(
            context = get()
        )
    }

    single<ApixuWeatherApiService> {
        ApixuWeatherApiService(
            connectivityInterceptor = get()
        )
    }

    single<WeatherNetworkDataSource> {
        WeatherNetworkDataSourceImpl(
            apixuWeatherApiService = get()
        )
    }
}
