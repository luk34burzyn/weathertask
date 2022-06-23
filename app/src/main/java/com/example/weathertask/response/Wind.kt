package com.example.weathertask.response

//wind
//wind.speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
//wind.deg Wind direction, degrees (meteorological)
//wind.gust Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
data class Wind(
    val deg: Int,
    val speed: Double
)