package com.example.weathertask.ui.adapter

import com.example.weathertask.utils.TimeOfDay
import java.time.LocalDateTime

data class WeatherItem (
    val id: Int,
    val timeOfDay: TimeOfDay,
    val dateDay: LocalDateTime,
    val mainTemp: Double,
    val minDayTemp: Double,
    val maxTemp: Double,
    val humidity: Int
)