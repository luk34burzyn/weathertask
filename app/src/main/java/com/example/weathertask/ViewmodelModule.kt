package com.example.weathertask

import com.example.weathertask.ui.weather.current.CurrentWeatherViewModel
import com.example.weathertask.ui.weather.future.FutureWeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { CurrentWeatherViewModel(get()) }
    viewModel { FutureWeatherViewModel(get()) }
}
