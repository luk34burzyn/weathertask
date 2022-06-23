package com.example.weathertask.response

import com.google.gson.annotations.SerializedName

//main.temp Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
//main.feels_like Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
//main.pressure Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
//main.humidity Humidity, %
//main.temp_min Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
//main.temp_max Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
//main.sea_level Atmospheric pressure on the sea level, hPa
//main.grnd_level Atmospheric pressure on the ground level, hPa

data class Main(
    @SerializedName("feels_like")
    val feels_like: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("temp_max")
    val temp_max: Double,
    @SerializedName("temp_min")
    val temp_min: Double
)
