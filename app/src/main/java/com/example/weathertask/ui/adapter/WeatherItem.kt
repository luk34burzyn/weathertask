package com.example.weathertask.ui.adapter

data class WeatherItem (
    val day: Int,
    val mainTemp: Double,
    val minDayTemp: Double,
    val maxTemp: Double,
    val humidity: Int
)