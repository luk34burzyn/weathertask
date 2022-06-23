package com.example.weathertask.response

//weather.id Weather condition id
//weather.main Group of weather parameters (Rain, Snow, Extreme etc.)
//weather.description Weather condition within the group. You can get the output in your language. Learn more
//weather.icon Weather icon id
data class WeatherX(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)