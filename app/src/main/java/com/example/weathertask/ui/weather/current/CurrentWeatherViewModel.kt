package com.example.weathertask.ui.weather.current

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertask.BuildConfig
import com.example.weathertask.data.ApixuWeatherApiService
import com.example.weathertask.data.network.ConnectivityInterceptor
import com.example.weathertask.data.network.WeatherNetworkDataSourceImpl
import com.example.weathertask.response.CurrentWeatherResponse
import com.example.weathertask.utils.LANGUAGE
import com.example.weathertask.utils.METRIC
import kotlinx.coroutines.launch

const val TAG = "CurrentWeatherViewModel"

class CurrentWeatherViewModel(private val connectivityInterceptor: ConnectivityInterceptor) :
    ViewModel() {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse> = _downloadedCurrentWeather

    fun init() {
        viewModelScope.launch {
            val apiService = ApixuWeatherApiService(connectivityInterceptor)
            val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

            _downloadedCurrentWeather.postValue(
                weatherNetworkDataSource.fetchCurrentWeather(
                    "London",
                    METRIC,
                    LANGUAGE,
                    BuildConfig.API_KEY
                )
            )
        }
    }

}