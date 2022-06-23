package com.example.weathertask.response

//sys.type Internal parameter
//sys.id Internal parameter
//sys.message Internal parameter
//sys.country Country code (GB, JP etc.)
//sys.sunrise Sunrise time, unix, UTC
//sys.sunset Sunset time, unix, UTC
data class Sys(
    val country: String,
    val id: Int,
    val message: Double,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)