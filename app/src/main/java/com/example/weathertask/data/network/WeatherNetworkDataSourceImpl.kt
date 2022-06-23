package com.example.weathertask.data.network

import android.util.Log
import com.example.weathertask.data.ApixuWeatherApiService
import com.example.weathertask.response.CurrentWeatherResponse
import com.example.weathertask.response.forecast.FiveDayResponse
import okio.IOException

class WeatherNetworkDataSourceImpl(
    private val apixuWeatherApiService: ApixuWeatherApiService
) : WeatherNetworkDataSource {

    override suspend fun fetchCurrentWeather(
        q: String?,
        units: String?,
        lang: String?,
        appId: String?
    ):CurrentWeatherResponse? {
        try {
            return apixuWeatherApiService
                .getCurrentWeatherAsync(q, units, lang, appId)
                .await()
        } catch (e: IOException) {
            Log.e("Connectivity", "No internet connection.", e)
        }
        return null
    }

    override suspend fun fetchForecastWeather(
        q: String?,
        units: String?,
        lang: String?,
        appId: String?
    ):FiveDayResponse? {
        try {
            return apixuWeatherApiService
                .getFiveDaysWeatherAsync(q, units, lang, appId)
                .await()
        } catch (e: IOException){
            Log.e("Connectivity", "No internet connection.", e)
        }
        return null
    }
}