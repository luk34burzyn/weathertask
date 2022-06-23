package com.example.weathertask.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse (
    @SerializedName("dt")
    var dt:Int = 0,
    @SerializedName("coord")
    var coord: Coord? = null,
    @SerializedName("weather")
    var weather: List<WeatherX>? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("cod")
    var cod:Int = 0,
    @SerializedName("main")
    var main: Main? = null,
    @SerializedName("clouds")
    var clouds: Clouds? = null,
    @SerializedName("id")
    var id:Long = 0,
    @SerializedName("sys")
    var sys: Sys? = null,
    @SerializedName("base")
    var base: String? = null,
    @SerializedName("wind")
    var wind: Wind? = null
)