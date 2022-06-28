package com.example.weathertask.ui.weather.future

import android.util.Log
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
import kotlinx.coroutines.launch

class FutureWeatherViewModel(
    private val connectivityInterceptor: ConnectivityInterceptor
) : ViewModel() {

    private val _downloadedForecastWeather = MutableLiveData<FiveDayResponse>()
    val downloadedForecastWeather: LiveData<FiveDayResponse> = _downloadedForecastWeather

    val listOfWeather : MutableList<WeatherItem> = mutableListOf()

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

    fun convertToItems(response: FiveDayResponse){
        for (item in 0..4){
            val fulfilledItem = WeatherItem(
                day = item + 1,
                mainTemp = response.list?.get(item)?.main?.temp ?: 0.0,
                minDayTemp = response.list?.get(item)?.main?.temp_min ?: 0.0,
                maxTemp = response.list?.get(item)?.main?.temp_max ?: 0.0,
                humidity = response.list?.get(item)?.main?.humidity ?: 0
            )
            listOfWeather.add(fulfilledItem)
        }
    }

}