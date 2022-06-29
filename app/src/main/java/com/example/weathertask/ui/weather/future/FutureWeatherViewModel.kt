package com.example.weathertask.ui.weather.future

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertask.BuildConfig
import com.example.weathertask.data.ApixuWeatherApiService
import com.example.weathertask.data.network.ConnectivityInterceptor
import com.example.weathertask.data.network.WeatherNetworkDataSourceImpl
import com.example.weathertask.response.forecast.FiveDayResponse
import com.example.weathertask.ui.adapter.WeatherItem
import com.example.weathertask.utils.LANGUAGE
import com.example.weathertask.utils.METRIC
import com.example.weathertask.utils.TimeOfDay
import com.example.weathertask.utils.whatTimeOfDay
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

class FutureWeatherViewModel(
    private val connectivityInterceptor: ConnectivityInterceptor
) : ViewModel() {

    private val _downloadedForecastWeather = MutableLiveData<FiveDayResponse>()
    val downloadedForecastWeather: LiveData<FiveDayResponse> = _downloadedForecastWeather

    val listOfWeather: MutableList<WeatherItem> = mutableListOf()

    fun init() {
        viewModelScope.launch {
            val apiService = ApixuWeatherApiService(connectivityInterceptor)
            val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

            _downloadedForecastWeather.postValue(
                weatherNetworkDataSource.fetchForecastWeather(
                    "London",
                    METRIC,
                    LANGUAGE,
                    BuildConfig.API_KEY
                )
            )
        }
    }

    fun convertToItems(response: FiveDayResponse) {
        var checkIfContained = TimeOfDay.MORNING
        for (item in 0..((response.list?.size?.minus(1)) ?: 0)) {
            val thisTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(response.list?.get(item)?.dt?.toLong()?.times(1000) ?: 0),
                TimeZone.getDefault().toZoneId()
            )

            val fulfilledItem = WeatherItem(
                id = item,
                timeOfDay = whatTimeOfDay(thisTime),
                dateDay = thisTime,
                mainTemp = response.list?.get(item)?.main?.temp ?: 0.0,
                minDayTemp = response.list?.get(item)?.main?.temp_min ?: 0.0,
                maxTemp = response.list?.get(item)?.main?.temp_max ?: 0.0,
                humidity = response.list?.get(item)?.main?.humidity ?: 0
            )

            if(item == 0 || checkIfContained != whatTimeOfDay(thisTime)) {
                listOfWeather.add(fulfilledItem)
                checkIfContained = whatTimeOfDay(thisTime)
            }

        }
    }

}