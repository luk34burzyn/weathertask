package com.example.weathertask.data.network

import androidx.lifecycle.LiveData
import com.example.weathertask.response.CurrentWeatherResponse
import com.example.weathertask.response.forecast.FiveDayResponse

interface WeatherNetworkDataSource {

    suspend fun fetchCurrentWeather(
        q: String?,
        units: String?,
        lang: String?,
        appId: String?
    ):CurrentWeatherResponse?

    suspend fun fetchForecastWeather(
        q: String?,
        units: String?,
        lang: String?,
        appId: String?
    ):FiveDayResponse?
}